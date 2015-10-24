package org.learn.interview;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SortingAlgorithmsTest {

	SortingAlgorithms obj = new SortingAlgorithms();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Integer[] a = {0, 1,2,3,4,5,6,100, 1000, 10001};
		assertEquals(obj.binarySearch(a, 10), new Integer(-1));
		assertEquals(obj.binarySearch(a, 0), new Integer(0));
		assertEquals(obj.binarySearch(a, 1), new Integer(1));
		assertEquals(obj.binarySearch(a, 2), new Integer(2));
		assertEquals(obj.binarySearch(a, 3), new Integer(3));
		assertEquals(obj.binarySearch(a, 4), new Integer(4));
		assertEquals(obj.binarySearch(a, 5), new Integer(5));
		assertEquals(obj.binarySearch(a, 6), new Integer(6));
		assertEquals(obj.binarySearch(a, 7), new Integer(-1));
		assertEquals(obj.binarySearch(a, 10001), new Integer(a.length-1));
		
	}

}