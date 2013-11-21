package de.hska.iwi.algolab.convexhull.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hska.iwi.algolab.convexhull.Point;

public class PointTest {

	private Point pA;
	private Point pB;
	private Point pC;
	private Point pD;
	private Point pE;
	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;
	
	
	@Before
	public void setUp() throws Exception {
		this.pA = new Point(4, 9);
		this.pB = new Point(1, 4);
		this.pC = new Point(3, 5);
		this.pD = new Point(5, 6);
		this.pE = new Point(4, 7);
		
		this.p1 = new Point(1, 1);
		this.p2 = new Point(2, 6);
		this.p3 = new Point(6, 8);
		this.p4 = new Point(4, 7);
		
		
	}

	@Test
	public void testPointAboveLine() {
		Assert.assertEquals(1, pA.positionToLine(p2, p3));
		Assert.assertEquals(1, pB.positionToLine(p1, p2));
		
		Assert.assertEquals(-1, pC.positionToLine(p1, p2));
		Assert.assertEquals(-1, pD.positionToLine(p2, p3));
		
		Assert.assertEquals(0, pE.positionToLine(p2, p3));
		Assert.assertEquals(0, p2.positionToLine(p1, p2));
		
	}


	@Test
	public void testCompare(){
		Assert.assertEquals(1, pA.compareTo(pB));
		Assert.assertEquals(1, pD.compareTo(pE));
		
		Assert.assertEquals(-1, pB.compareTo(pA));
		Assert.assertEquals(-1, pE.compareTo(pD));
		
		//x is equal
		Assert.assertEquals(1, pA.compareTo(pE));
		Assert.assertEquals(-1, pE.compareTo(pA));
		Assert.assertEquals(0, pE.compareTo(p4));
		
		
	}
	
	@Test
	public void testToString(){
		Assert.assertEquals("["+pA.getX()+","+pA.getY()+"]", pA.toString());
		Assert.assertEquals("["+pB.getX()+","+pB.getY()+"]", pB.toString());
		
	}
	
	
}
