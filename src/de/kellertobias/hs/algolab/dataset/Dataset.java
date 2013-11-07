package de.kellertobias.hs.algolab.dataset;

import java.util.List;
import de.kellertobias.hs.algolab.convexhull.Point;

public interface Dataset {
	
	public void regeneratePoints(int amount);
	public List<Point> getPoints();
	public String toString();
	
}
