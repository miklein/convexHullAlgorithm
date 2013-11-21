package de.kellertobias.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.kellertobias.hs.algolab.convexhull.Point;

/**
 * Testdataset where all Points are defined on a circle
 * @author Tobias Keller
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
		//double step = (Math.PI * 2) / amount;
		
		for (int i=0; i < amount; i++) {
			//double x = Math.cos(i*step) * radius;
			//double y = Math.sin(i*step) * radius;
			
			double rand = Math.random();
			double x = Math.cos(((Math.PI * 2) *  rand)) * radius;
			double y = Math.sin(((Math.PI * 2) *  rand)) * radius;
			
			this.points.add(new Point(x,y));
		}
	}

}
