package de.kellertobias.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;

/**
 * Dataset where all Points are on a circle
 * @author Michael Klein
 *
 */
public class CircleDataset implements Dataset {

	private List<Point> points = new ArrayList<Point>();
	
	public CircleDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	
	public String toString() {
		return "circle";
	}
	
	@Override
	public List<Point> getPoints() {
		return this.points;
	}


	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		double radius = 10;
		double step = (Math.PI * 2) / amount;
		
		for (int i=0; i < amount; i++) {
			double x = Math.cos(i*step) * radius;
			double y = Math.sin(i*step) * radius;
			this.points.add(new Point(x,y));
		}
	}

}
