package de.kellertobias.hs.algolab.convexhull;

/**
 * Point in an 2D-System
 * @author Michael Klein
 *
 */
public class Point implements Comparable<Point> {
	
	private double x;
	private double y;
	
	/** 
	 * create a new Point at position x,y
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * get the x-value of the point
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * get the y-value of the point
	 * @return
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * set the x-value of the point
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * set the y-value of the point
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * check if this point is above the line between the given points
	 * @param start Startpoint of the line
	 * @param end Endpoint of the line
	 * @return 1 if the point is left (above) the line, 
	 * -1 if it is right (below) and 0 if it is on the line
	 */
	public int positionToLine(Point start, Point end) {
		
		// vector from start to end
		double v1x = end.getX() - start.getX();
		double v1y = end.getY() - start.getY();
		
		// vector from start to this point
		double v2x = this.getX() - start.getX();
		double v2y = this.getY() - start.getY();
		
		// crossproduct
		double crossProduct = (v1x * v2y) - (v1y * v2x);
		if (crossProduct > 0) return 1;			// point is left (above) the line
		if (crossProduct < 0) return -1;		// point is right (below) the line
		return 0;								// point is on the line		
	}
	
	

	
	/**
	 * returns the x and y-value as a string
	 */
	public String toString() {
       return "["+x+","+y+"]";
    }


	@Override
	/**
	 * Compares point first after x and if x is equal after y
	 */
	public int compareTo(Point point) {
		if (this.getX() < point.getX()) return -1;
		if (this.getX() > point.getX()) return 1;
		if (this.getY() < point.getY()) return -1;
		if (this.getY() > point.getY()) return 1;
		return 0;
	}
}
