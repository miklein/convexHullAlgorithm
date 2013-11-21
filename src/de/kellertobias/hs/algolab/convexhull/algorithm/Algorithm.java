package de.kellertobias.hs.algolab.convexhull.algorithm;


import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;
import de.kellertobias.hs.algolab.dataset.Dataset;

/**
 * All Algorithms that implement an Convex-Hull Solution implement this class
 * @author Tobias Keller
 *
 */
public interface Algorithm {
	
	/**
	 * Calculates the convex-hull of all Points in the dataset
	 * @param dataset List of all Points
	 * @return Points of the convex-hull
	 */
	 public List<Point> calculate(Dataset dataset);
	
}
