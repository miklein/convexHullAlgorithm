package de.kellertobias.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.kellertobias.hs.algolab.convexhull.Point;

public class RandomDataset implements Dataset {

	private List<Point> points = new ArrayList<Point>();
	
	
	public RandomDataset(int amount) {
		Random random = new Random(System.nanoTime());
		for (int i=0; i < amount; i++) {
			this.points.add(new Point(random.nextDouble(), random.nextDouble()));
		}
	}
	
	
	@Override
	public List<Point> getPoints() {
		return this.points;
	}

}
