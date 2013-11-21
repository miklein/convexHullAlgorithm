package de.hska.iwi.algolab.dataset;

import java.util.List;

import de.hska.iwi.algolab.convexhull.Point;

/**
 * Interface for Datasets
 * @author Michael Klein
 *
 */
public interface Dataset {
	
	/**
	 * Generate a new set of Points
	 * @param amount the amount of points
	 */
	public void regeneratePoints(int amount);
	
	/**
	 * get all points
	 * @return
	 */
	public List<Point> getPoints();
	
	/**
	 * get the name of the dataset-type
	 * @return
	 */
	public String toString();
	
}
