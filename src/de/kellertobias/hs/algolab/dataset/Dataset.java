package de.kellertobias.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;

/**
 * Interface that is implemented by all Datasets
 * @author Tobias Keller
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
