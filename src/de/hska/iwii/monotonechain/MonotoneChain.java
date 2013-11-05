package de.hska.iwii.monotonechain;

import java.util.ArrayList;
import java.util.List;

public class MonotoneChain {

	public static void main(String[] args) {
		
		List<Point> pointList = new ArrayList<>();

		pointList.add(new Point(1, 1));
		pointList.add(new Point(3, 2));
		pointList.add(new Point(3, 2));

		int tmp = pointList.get(2).isAboveLine(pointList.get(0), pointList.get(1));
		if (tmp == 0) {
			System.out.println("on line");
		}
		if (tmp == 1) {
			System.out.println("left");
		}
		if (tmp == -1) {
			System.out.println("right");
		}
		
		
		//Algorithm monotoneChainAlgo = new Algorithm();
		//printList(monotoneChainAlgo.MonotoneChain(pointList));
		printList(pointList);

	}
	
	
	//test
	public static void printList(List<Point> pointList){
		for (Point point : pointList) {
			System.out.println(point);
		}
	}

}
