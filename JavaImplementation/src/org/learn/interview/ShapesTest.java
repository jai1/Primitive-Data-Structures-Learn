package org.learn.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShapesTest {

	Shapes sh = new Shapes();
	@Before
	public void setUp() throws Exception {	
		
	}

	@Test
	public void test1() {
		Point[] r1 = {	new Point(0, 0), new Point(1, 3), 
						new Point(1,0), new Point(0,3)};
		Point[] r2 = {	new Point(-1, -1), new Point(1, 3), 
						new Point(1,-1), new Point(-1,3)};
		assertTrue(sh.doRectangleOverlap(r1, r2));
	}
	@Test
	public void test2() {
		Point[] r1 = {	new Point(0, 0), new Point(1, 3), 
						new Point(1,0), new Point(0,3)};
		Point[] r2 = {	new Point(-1, -1), new Point(1, 1), 
						new Point(1,-1), new Point(-1,1)};
		assertTrue(sh.doRectangleOverlap(r1, r2));
	}

	@Test
	public void test3() {
		Point[] r1 = {	new Point(0, 0), new Point(1, 3), 
						new Point(1,0), new Point(0,3)};
		Point[] r2 = {	new Point(-10, -10), new Point(-1, -1), 
						new Point(-1,-10), new Point(-10,-1)};
		assertFalse(sh.doRectangleOverlap(r1, r2));
	}

	@Test
	public void test4() {
		Point c1 = new Point(0, 0);
		Point c2 = new Point(3,3);
		float radius1 = 2f;
		float radius2 = 2.2f;
		assertFalse(sh.doCirclesOverlap(c1, radius1, c2, radius2));
		
		radius1 = 2f;
		radius2 = 2.3f;
		assertTrue(sh.doCirclesOverlap(c1, radius1, c2, radius2));
	}
}
