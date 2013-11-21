package de.hska.iwi.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hska.iwi.algolab.convexhull.Point;

/**
 * Dataset that calculates random points
 * @author Michael Klein
 *
 */
public class RandomDataset implements Dataset {

	private List<Point> points = new ArrayList<Point>();
	
	
	public RandomDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	public String toString() {
		return "random";
	}
	
	@Override
	public List<Point> getPoints() {
		return this.points;
	}

	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		Random random = new Random(System.nanoTime());
		for (int i=0; i < amount; i++) {
			this.points.add(new Point(random.nextDouble(), random.nextDouble()));
		}
	}

}
