package de.kellertobias.hs.algolab.convexhull;


public class Point implements Comparable<Point> {
	
	private double x;
	private double y;
	
	
	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
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
