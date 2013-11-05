package de.hska.iwii.monotonechain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algorithm {

	
	
	public List<Point> MonotoneChain(List<Point> points) {

		List<Point> convexEnvelope = new ArrayList<Point>();
		
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x < p2.x) {
					return -1;
				} else if (p1.x > p2.x) {
					return 1;
				} else {		//x is equal
					if (p1.y < p2.y) {
						return -1;
					} else if (p1.y > p2.y) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});

		
		convexEnvelope.add(points.get(0));
		convexEnvelope.add(points.get(1));
		
		
	
		return points;

	}
	
}
