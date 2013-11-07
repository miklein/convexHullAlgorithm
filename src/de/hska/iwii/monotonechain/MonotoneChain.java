package de.hska.iwii.monotonechain;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MonotoneChain {

	
	
	
	
	public static void main(String[] args) {
		
		List<Point> pointList = new ArrayList<>();

		pointList.add(new Point(1,1));
		pointList.add(new Point(2,6));
		pointList.add(new Point(3,4));
		pointList.add(new Point(9,4));
		pointList.add(new Point(5,7));
		pointList.add(new Point(7,3));
		pointList.add(new Point(6,8));
		pointList.add(new Point(7,5));
		
		
		

		
		
		

//		int tmp = pointList.get(2).isAboveLine(pointList.get(0), pointList.get(1));
//		if (tmp == 0) {
//			System.out.println("on line");
//		}
//		if (tmp == 1) {
//			System.out.println("left");
//		}
//		if (tmp == -1) {
//			System.out.println("right");
//		}
		
		
		Algorithm monotoneChainAlgo = new Algorithm();
		
		printList(monotoneChainAlgo.MonotoneChain(pointList));
		//printList(pointList);

	}
	
	
	
	public static void printList(List<Point> pointList){
		for (Point point : pointList) {
			System.out.println(point);
		}
	}

}
