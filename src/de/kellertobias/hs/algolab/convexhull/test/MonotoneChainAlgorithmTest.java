package de.kellertobias.hs.algolab.convexhull.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.kellertobias.hs.algolab.convexhull.Point;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;

public class MonotoneChainAlgorithmTest {

	private MonotoneChainAlgorithm algorithm;
	
	
	private List<Point> pointList;
	private List<Point> circleList;
	
	
	 @Before
	    public void setUp() {
		 algorithm = new MonotoneChainAlgorithm();
		 
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1,1));
		points.add(new Point(2,6));
		points.add(new Point(3,4));
		points.add(new Point(9,4));
		points.add(new Point(7,5));
		points.add(new Point(7,3));
		points.add(new Point(6,8));
		points.add(new Point(6,8));
		this.pointList = points;
		
		List<Point> circlePoints = new ArrayList<Point>();
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));
		circlePoints.add(new Point(1,1));	
		this.circleList = circlePoints;
		
	    }
	
	@Test
	public void testAlgorithm() {
		List<Point> convexHull = new ArrayList<Point>();
		convexHull.add(new Point(2,6));
		convexHull.add(new Point(6,8));
		convexHull.add(new Point(9,4));
		convexHull.add(new Point(7,3));
		convexHull.add(new Point(1,1));
		
		int i = 0;
		
		for (Point point : algorithm.calculate(pointList)) {
		Assert.assertEquals(convexHull.get(i).getX(), point.getX(), 0.0);
		Assert.assertEquals(convexHull.get(i).getY(), point.getY(), 0.0);
		i++;
		}
		
		//assertArrayEquals(convexHull, algorithm.calculate(pointList));
//		assertThat(algorithm.calculate(pointList), 
//			       IsIterableContainingInOrder.contains(convexHull.toArray()));
		
	}
	
	@Test
	public void testAlgorithmOnCircle() {
		
		
		
	}

	@Test
	public void testOnlyTwoPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(6,4));
		points.add(new Point(6,8));
		
		List<Point> calculatedHull = algorithm.calculate(points);
		
		
		Assert.assertEquals(points.get(0).getX(), calculatedHull.get(0).getX(), 0.0);
		Assert.assertEquals(points.get(0).getY(), calculatedHull.get(0).getY(), 0.0);
		
		Assert.assertEquals(points.get(1).getX(), calculatedHull.get(1).getX(), 0.0);
		Assert.assertEquals(points.get(1).getY(), calculatedHull.get(1).getY(), 0.0);
		
	}
	
	
}
