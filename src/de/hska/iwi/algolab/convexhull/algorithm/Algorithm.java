package de.hska.iwi.algolab.convexhull.algorithm;


import java.util.List;

import de.hska.iwi.algolab.convexhull.Point;

/**
 * Interface for Algorithms for Convex-Hull calculation 
 * @author Michael Klein
 *
 */
public interface Algorithm {
	
	/**
	 * Calculates the convex-hull of all Points from the dataset
	 * @param dataset List points
	 * @return Points of the convex-hull
	 */
	 public List<Point> calculate(List<Point> dataset);
	
}
