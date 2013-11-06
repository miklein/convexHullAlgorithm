package de.hska.iwii.monotonechain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm {

		
	public List<Point> MonotoneChain(List<Point> points) {

		List<Point> convexEnvelopeUpper = new ArrayList<Point>();
		List<Point> convexEnvelopeLower = new ArrayList<Point>();
		
		Collections.sort(points);
 
		if (points.size() <= 2) return points;
		

		// upper hull
		int k=0;
		
		// initiate the list with the first two points
		convexEnvelopeUpper.add(points.get(k++));
		convexEnvelopeUpper.add(points.get(k++));
		
		// walk through all points except the first 2 (they are already in the list)
		for (int pc=2; pc < points.size(); pc++) {
			Point point = points.get(pc);
			
			Point hm1 = convexEnvelopeUpper.get(k-1);
			Point hm2 = convexEnvelopeUpper.get(k-2);
			
			// as long as the previous point (hm1) is above the vector from hm2 to the current point and k has at least 2 entries
			while (hm1.isAboveLine(hm2, point) <= 0 && k >= 2) {
				
				// remove the last item in the list
				convexEnvelopeUpper.remove(k-1);
				k--;
				if (k >= 2) {
					hm1 = convexEnvelopeUpper.get(k-1);
					hm2 = convexEnvelopeUpper.get(k-2);
				}
			}
			// add the current point to the list
			convexEnvelopeUpper.add(point);
			k++;
		}
		
		
		
		// lower hull
		k=2;
		convexEnvelopeLower.add(points.get(points.size()-1));
		convexEnvelopeLower.add(points.get(points.size()-2));
		
		for (int pc=points.size()-3; pc >= 0; pc--) {
			Point point = points.get(pc);
			
			Point hm1 = convexEnvelopeLower.get(k-1);
			Point hm2 = convexEnvelopeLower.get(k-2);
			
			while (hm1.isAboveLine(hm2, point) <= 0 && k >= 2) {
				convexEnvelopeLower.remove(k-1);
				k--;
				if (k >= 2) {
					hm1 = convexEnvelopeLower.get(k-1);
					hm2 = convexEnvelopeLower.get(k-2);
				}
			}
			convexEnvelopeLower.add(point);
			k++;
		}
				
		convexEnvelopeLower.remove(0);
		convexEnvelopeUpper.remove(0);
		convexEnvelopeUpper.addAll(convexEnvelopeLower);
		
		
		return convexEnvelopeUpper;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// lower hull
//		for (int pc=points.size()-3; pc >= 0; pc--) {
//			Point point = points.get(pc);
//			for (int i=0; i < k; i++) {
//				Point hm1 = convexEnvelopeLower.get(k-1);
//				Point hm2 = convexEnvelopeLower.get(k-2);
//			//	System.out.println("prüfe ob "+hm1+" oberhabl von "+hm2+"->"+point);
//				
//				if (hm1.isAboveLine(hm2, point) <= 0) {
//			//		System.out.println("ja -> entferne "+hm1);
//					convexEnvelopeLower.remove(k-1);
//					k--;
//				} else {
//			//		System.out.println("nö");
//					i = k;
//				}
//				convexEnvelopeLower.add(point);
//			//	System.out.println("füge "+point+" hinzu");
//				k++;
//				
//			//	System.out.println("k="+k+" ("+convexEnvelopeLower.size()+")");
//			}
//			
//		}
		

	//	MonotoneChain.printList(convexEnvelopeLower);
//		
//
//		System.out.println("---:");
//		
//			
////			
////			
////			while (k >= 2) {
////				Point hm1 = convexEnvelope.get(k-1);
////				Point hm2 = convexEnvelope.get(k-2);
////				
////				if (hm1.isAboveLine(hm2, point) <= 0) {
////					convexEnvelope.remove(k-1);
////					k--;
////				}
////			}
////			convexEnvelope.add(point);
////			k++;
//		
//		
//		return convexEnvelopeLower;
		
		
// 		FUNKTIONIERT!!!!		
//		int k = 0;
//		
//		// build lower hull
//		for (int i=0; i < points.size(); i++) {
//			while (k >= 2 && points.get(i).isAboveLine(convexEnvelope.get(k-2), convexEnvelope.get(k-1)) <= 0) {
//				k--;
//				convexEnvelope.remove(k);
//			}
//			k++;
//			convexEnvelope.add(points.get(i));
//			//convexEnvelope.set(k++, points.get(i));
//		}
//
//		// build upper hull
//		for (int i=points.size()-2, t=k+1; i >= 0; i--) {
//			while (k >= t && points.get(i).isAboveLine(convexEnvelope.get(k-2), convexEnvelope.get(k-1)) <= 0) {
//				k--;
//				convexEnvelope.remove(k);
//			}
//			k++;
//			convexEnvelope.add(points.get(i));
//		}
//		
//		
//		return convexEnvelope;
	
		
		
		
		
		
		
//		
//		
//		//the 2 start points
//		convexEnvelope.add(points.get(0));
//		convexEnvelope.add(points.get(1));
//		
//		int i = 2;
//		
//		for (Point point : points) {
//			while (convexEnvelopeLower.size() >= 2 && point.isAboveLine(convexEnvelopeLower.get(i-2), convexEnvelopeLower.get(i-2)) <= 0) {
//				convexEnvelopeLower.remove(i);
//			}
//			convexEnvelopeLower.add(points.get(i));
//		}
//		
//		
//		
//
//		
//		
//		
//	
//		return points;

	}
		
	
}
