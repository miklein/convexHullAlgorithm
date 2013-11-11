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
		
		//int i++;
		//int m = Math.min(Math.pow(2, Math.pow(2, i)), dataset.size());
		
		int i = 0;
		int m = 0;
		Algorithm algo = new MonotoneChainAlgorithm();
		
		do {
			m = (int) Math.min(Math.pow(2, Math.pow(2, i)), dataset.size());
			
			List<List<Point>> subsets = this.createSubsets(dataset, m);
			List<List<Point>> convexHulls = new ArrayList<List<Point>>();
			
						
			for (List<Point> subset : subsets) {
				convexHulls.add(algo.calculate(subset));
			}
			
			
			System.out.println("Jetzt gehts los..");
			System.out.println(subsets);
			
			// javis march
			List<Point> output = new ArrayList<Point>();
			output.add(farthesLeftPoint);
			int hullIndex = 1;
			for (int j=0; j < m; j++) {
				
				// calculate angle between last output point and the stepIndex-Point of the subset
				Point startpoint = output.get(output.size()-1);
				
				Point tempPoint = null;
				
				for (int k=0; k < convexHulls.size(); k++) {
					int safeHullIndex = hullIndex % convexHulls.get(k).size();
					System.out.println("k="+k+ " hullIndex="+hullIndex+"safeHullIndex="+safeHullIndex);
					System.out.println("hull:"+convexHulls.get(k));
					if (tempPoint == null || convexHulls.get(k).get(safeHullIndex).isAboveLine(startpoint, tempPoint) == 1) {
						tempPoint = convexHulls.get(k).get(safeHullIndex);
						System.out.println("neues temp="+tempPoint);
					}
				}
				
				if (tempPoint == farthesLeftPoint) {
					System.out.println("FINALE Lösung Runde "+i+" => "+ output);
					return output;
				}

				if (tempPoint != null) {
					output.add(tempPoint);
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
