package de.hska.iwii.monotonechain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MonotoneChain {

	public static void main(String[] args) {
		
		List<Point> pointList = new ArrayList<>();
		pointList.add(new Point(7, 5));
		pointList.add(new Point(1, 1));
		pointList.add(new Point(6, 8));
		pointList.add(new Point(2, 6));
		pointList.add(new Point(9, 4));
		pointList.add(new Point(3, 4));
		pointList.add(new Point(7, 3));
	
		
		Algorithm monotoneChainAlgo = new Algorithm();
		printList(monotoneChainAlgo.MonotoneChain(pointList));
		

	}
	
	
	
	public static void printList(List<Point> pointList){
		for (Point point : pointList) {
			System.out.println(point);
		}
	}

}
