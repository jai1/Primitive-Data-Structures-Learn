package org.learn.interview;

public class Point {
	public Integer x;
	public Integer y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point p) {
		return (p.x == this.x && p.y == this.y);
	}
	
    @Override
    public boolean equals(Object object)
    {

        return (object != null &&
        		object instanceof Point &&
        		equals((Point)object));
	}
	
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}
}
