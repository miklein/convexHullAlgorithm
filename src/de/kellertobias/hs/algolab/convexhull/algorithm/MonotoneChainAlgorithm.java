package de.kellertobias.hs.algolab.convexhull.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;

public class MonotoneChainAlgorithm implements Algorithm {

	@Override
	public List<Point> calculate(List<Point> dataset) {
		
		List<Point> upperHull = new ArrayList<Point>();
		List<Point> lowerHull = new ArrayList<Point>();
		
		// sort the points
		Collections.sort(dataset);
		
		// no need to calculate something
		if (dataset.size() <= 2) return dataset;
		
		
		// calculate upper hull
		int k=0;
		
		// initiate the list with the first two points
		upperHull.add(dataset.get(k++));
		upperHull.add(dataset.get(k++));
		
		// walk through all points except the first 2 (they are already in the list)
		for (int pc=2; pc < dataset.size(); pc++) {
			Point point = dataset.get(pc);
			
			Point hm1 = upperHull.get(k-1);
			Point hm2 = upperHull.get(k-2);
			
			// as long as the previous point (hm1) is above the vector from hm2 to the current point and k has at least 2 entries
			while (hm1.isAboveLine(hm2, point) <= 0 && k >= 2) {
				
				// remove the last item in the list
				upperHull.remove(k-1);
				k--;
				if (k >= 2) {
					hm1 = upperHull.get(k-1);
					hm2 = upperHull.get(k-2);
				}
			}
			// add the current point to the list
			upperHull.add(point);
			k++;
		}
		
		
		// calculate lower hull
		k=2;
		lowerHull.add(dataset.get(dataset.size()-1));
		lowerHull.add(dataset.get(dataset.size()-2));
		
		for (int pc=dataset.size()-3; pc >= 0; pc--) {
			Point point = dataset.get(pc);
			
			Point hm1 = lowerHull.get(k-1);
			Point hm2 = lowerHull.get(k-2);
			
			while (hm1.isAboveLine(hm2, point) <= 0 && k >= 2) {
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
		lowerHull.remove(0);
		upperHull.remove(0);
		upperHull.addAll(lowerHull);
		
		return upperHull;
	}

}
