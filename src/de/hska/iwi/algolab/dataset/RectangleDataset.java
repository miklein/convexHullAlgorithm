package de.hska.iwi.algolab.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hska.iwi.algolab.convexhull.Point;

/**
 * Dataset in which all Points are inside of a rectangle and also on its edges
 * @author Michael Klein
 *
 */
public class RectangleDataset implements Dataset {

	private List<Point> points = new ArrayList<Point>();
	
	public RectangleDataset(int amount) {
		this.regeneratePoints(amount);
	}
	
	public String toString() {
		return "rectangle";
	}
	
	@Override
	public List<Point> getPoints() {
		return this.points;
	}

	@Override
	public void regeneratePoints(int amount) {
		this.points.clear();
		Point topLeft = new Point(0,(int)Math.sqrt(amount)*2);
		Point bottomRight = new Point((int)Math.sqrt(amount)*2,0);
				
		for (int i=0; i < amount; i++) {
			int x = (int)(Math.random() * ((bottomRight.getX()+1 - topLeft.getX())) + topLeft.getX());
			int y = (int) (Math.random() * ((topLeft.getY()+1 - bottomRight.getY())) + bottomRight.getY());
						
			if (x > bottomRight.getX()) x = (int)bottomRight.getX();
			if (y > topLeft.getY()) y = (int)topLeft.getY();
			
			this.points.add(new Point((double)x,(double)y));
		}
		
		// add the corner-points
		this.points.add(topLeft);
		this.points.add(bottomRight);
		this.points.add(new Point(bottomRight.getX(), topLeft.getY()));
		this.points.add(new Point(topLeft.getX(), bottomRight.getY()));
	}

}
