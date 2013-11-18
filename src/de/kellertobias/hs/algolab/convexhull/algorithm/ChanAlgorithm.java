package de.kellertobias.hs.algolab.convexhull.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;

public class ChanAlgorithm implements Algorithm {

	@Override
	public List<Point> calculate(List<Point> dataset) {
		
		Collections.sort(dataset);
		Point farthesLeftPoint = dataset.get(0);
		
		if (dataset.size() < 3) {
			// do something..
		}
				
		int i = 0;
		int m = 0;
		Algorithm monotoneChainAlgo = new MonotoneChainAlgorithm();
		
		do {
			m = (int) Math.min(Math.pow(2, Math.pow(2, i)), dataset.size());		// m = min{2^2^i, n}
			
						
			List<List<Point>> subsets = createSubsets(dataset, m);
			List<List<Point>> convexHulls = new ArrayList<List<Point>>();
			
						
			for (List<Point> subset : subsets) {
				convexHulls.add(monotoneChainAlgo.calculate(subset));
			}
			
			
			System.out.println("Jetzt gehts los..");
			System.out.println(subsets);
			
			// javis march
			List<Point> output = new ArrayList<Point>();
			output.add(farthesLeftPoint);
			int hullIndex = 1;			//Begin with second hull point
			// Roundlength depend of the choosen size of m
			for (int j=0; j < m; j++) {
				
				// calculate angle between last output point and the stepIndex-Point of the subset
				Point startpoint = output.get(output.size()-1);
				
				Point newStartPoint = null;					
						
				for (int currentHull = 0; currentHull < convexHulls.size(); currentHull++) {
					int safeHullIndex = hullIndex % convexHulls.get(currentHull).size();
					System.out.println("currentHull="+currentHull + " hullIndex="+hullIndex+" safeHullIndex="+safeHullIndex);
					System.out.println("hull:"+convexHulls.get(currentHull));
					//If current point from convexHullPart is left from line startpoint -> 
					if (newStartPoint == null || convexHulls.get(currentHull).get(safeHullIndex).isAboveLine(startpoint, newStartPoint) == 1) {
						newStartPoint = convexHulls.get(currentHull).get(safeHullIndex);
						System.out.println("new startpoint="+newStartPoint);
					}
				}
				
				// Terminate if back at farthest left point -> startpoint of the hull
				if (newStartPoint == farthesLeftPoint) {
					System.out.println("FINALE Lösung Runde "+i+" => "+ output);
					return output;
				}

				if (newStartPoint != null) {
					output.add(newStartPoint);
				}
				hullIndex++;
			}
			
			System.out.println("Lösung Runde "+i+" => "+ output);
			
			i++;
		} while(i < dataset.size());
		return null;
	}

	
	private List<List<Point>> createSubsets(List<Point> points, int m) {
		List<List<Point>> subsets = new ArrayList<List<Point>>();
		double n = points.size();
		int i=0, subset=0;
		for (Point point : points) {
			if (i == Math.ceil(n / (double)m)) {
				i = 0;
				subset++;
			}
			if (i == 0) {
				List<Point> tmp = new ArrayList<Point>();
				subsets.add(tmp);
			}
			subsets.get(subset).add(point);
			i++;
		}
		return subsets;
	}
	
	
	
}
