package de.hska.iwii.monotonechain;


public class Point implements Comparable<Point> {
	
	private int x;
	private int y;
	
	
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int isAboveLine(Point start, Point end) {
		
		// vector from start to end
		double v1x = end.getX() - start.getX();
		double v1y = end.getY() - start.getY();
		
		// vector from start to this point
		double v2x = this.getX() - start.getX();
		double v2y = this.getY() - start.getY();
		
		// crossproduct
		double cp = (v1x * v2y) - (v1y * v2x);
		if (cp > 0) return 1;	// point is above (left) the line
		if (cp < 0) return -1;	// point is below (right) the line
		return 0;					// point is on the line		
		
		/**
		// vectorproduct of v1 and v2
		int vp = v1x * v2x + v1y * v2y;
		
		// product of the lengths of the vectors
		double pl = Math.sqrt(Math.pow(v1x, 2) + Math.pow(v1y, 2)) * Math.sqrt(Math.pow(v2x, 2) + Math.pow(v2y, 2));
		
		// angle between v1 and v2
		double tmp = vp / pl;
		double angle = Math.acos(tmp) * 180/Math.PI;
		
		System.out.print("vp="+vp+" pl="+pl+" angle="+angle + " tmp="+tmp);
		
		if (angle > 0) return 1;	// point is above (left) the line
		if (angle < 0) return -1;	// point is below (right) the line
		return 0;					// point is on the line
		**/
	}
	
	
	public String toString() {
       return "["+x+","+y+"]";
		// return getClass().getName() + "[x=" + x + ",y=" + y + "]";
    }


	@Override
	public int compareTo(Point point) {
		if (this.getX() < point.getX()) return -1;
		if (this.getX() > point.getX()) return 1;
		if (this.getY() < point.getY()) return -1;
		if (this.getY() > point.getY()) return 1;
		return 0;
	}
}
