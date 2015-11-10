package org.learn.interview;

public class Shapes {

	/*
	 * Company:- Avaya 
	 * Question:- Given co ordinates of a rectangle find if two
	 * rectangles overlap.
	 */

	boolean doRectangleOverlap(Point[] r1, Point[] r2) {
		Point r1Min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Point r1Max = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
		calMinMaxPtOfRect(r1, r1Min, r1Max);

		Point r2Min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Point r2Max = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
		calMinMaxPtOfRect(r2, r2Min, r2Max);

		if(r1Max.x < r2Min.x || r1Min.x > r2Max.x)
			return false;
		
		if(r1Max.y < r2Min.y || r1Min.y > r2Max.y)
			return false;
		
		return true;
	}

	private void calMinMaxPtOfRect(Point[] r1, Point r1Min, Point r1Max) {
		for (int i = 0; i < r1.length; i++) {
			if (r1[i].x < r1Min.x)
				r1Min.x = r1[i].x;
			if (r1[i].y < r1Min.y)
				r1Min.y = r1[i].y;

			if (r1[i].x > r1Max.x)
				r1Max.x = r1[i].x;
			if (r1[i].y > r1Max.y)
				r1Max.y = r1[i].y;
		}
	}
	
	/*
	 * Company: Google
	 * Question:- Given the center and the radii of 2 circles find if they
	 *            overlap.
	 */
	boolean doCirclesOverlap(Point center1, float radius1, Point center2, float radius2) {
		float sumOfRadius = radius1 + radius2;
		
		return ((Math.pow((center1.x - center2.x), 2) +
				(Math.pow((center1.y - center2.y), 2)) 
				<= Math.pow(sumOfRadius, 2)));
	}

}
