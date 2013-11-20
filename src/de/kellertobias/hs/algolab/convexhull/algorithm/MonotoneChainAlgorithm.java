package de.kellertobias.hs.algolab.convexhull.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import de.kellertobias.hs.algolab.convexhull.Point;

/**
 * Monotone Chain Algorithm to calculate the convex hull from a point dataset 
 * @author Michael Klein
 *
 */
public class MonotoneChainAlgorithm implements Algorithm {

	@Override
	public List<Point> calculate(List<Point> dataset) {
		ListIterator<Point> datasetIterator = dataset.listIterator();
		List<Point> upperHull = new ArrayList<Point>();
		List<Point> lowerHull = new ArrayList<Point>();
		
		Collections.sort(dataset);
		
		
		if (dataset.size() <= 2){
			// no calculation needed
			return dataset;
		}
		
		
		// calculate upper hull
		
		// initiate the list with the first two points
		upperHull.add(datasetIterator.next());
		upperHull.add(datasetIterator.next());
		
		int k=2;
		
		// walk through all points except the first 2 (they are already in the list)
		while(datasetIterator.hasNext()) {
			Point currentPoint = datasetIterator.next();
			
			Point point1 = upperHull.get(k-1);
			Point point2 = upperHull.get(k-2);
			
			// as long as the previous point (point1) is left the vector from point2 to the current point and k has at least 2 entries
			while (point1.positionToLine(point2, currentPoint) <= 0 && k >= 2) {
				upperHull.remove(k-1);
				k--;
				if (k >= 2) {
					point1 = upperHull.get(k-1);
					point2 = upperHull.get(k-2);
				}
			}
			upperHull.add(currentPoint);
			k++;
		}
		
		
		
		// calculate lower hull
		
		lowerHull.add(datasetIterator.previous());
		lowerHull.add(datasetIterator.previous());
		k=2;
		
		while(datasetIterator.hasPrevious()) {
			Point point = datasetIterator.previous();
			
			Point hm1 = lowerHull.get(k-1);
			Point hm2 = lowerHull.get(k-2);
			
			while (hm1.positionToLine(hm2, point) <= 0 && k >= 2) {
				lowerHull.remove(k-1);
				k--;
				if (k >= 2) {
					hm1 = lowerHull.get(k-1);
					hm2 = lowerHull.get(k-2);
				}
			}
			lowerHull.add(point);
			k++;
		}
		
		// remove the first elements in the list and merge them
		lowerHull.remove(lowerHull.size()-1);
		upperHull.remove(upperHull.size()-1);
		upperHull.addAll(lowerHull);
		
		
		return upperHull;
	}

}
