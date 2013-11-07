package de.kellertobias.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;

public class TestDataset implements Dataset {

	@Override
	public List<Point> getPoints() {
		
		List<Point> pointList = new ArrayList<>();

		pointList.add(new Point(1,1));
		pointList.add(new Point(2,6));
		pointList.add(new Point(3,4));
		pointList.add(new Point(9,4));
		pointList.add(new Point(5,7));
		pointList.add(new Point(7,3));
		pointList.add(new Point(6,8));
		pointList.add(new Point(7,5));
		
		return pointList;
	}
	

	public String toString() {
		return "test";
	}


	@Override
	public void regeneratePoints(int amount) {
		// TODO Auto-generated method stub
		
	}
}
