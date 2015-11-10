package org.learn.interview;

public class Point {
	public float x;
	public float y;

	public Point(float x, float y) {
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
