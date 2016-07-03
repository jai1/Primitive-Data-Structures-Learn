package org.learn.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SearchAndSortAlgosTest {

	SearchAndSortAlgos obj = new SearchAndSortAlgos();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
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

	@Test
	public void test2() {
		List a = new ArrayList();
		a.add(-1);
		a.add(2);
		a.add(0);
		a.add(99);
		a.add(1);
		a.add(2);
		a.add(-1);
		a.add(3);
		a.add(5);
		a.add(23);
		a.add(-20);
		a.add(22);
		a.add(-109);
		a.add(110);
		a.add(-10);
		a.add(101);
		obj.mergeSort(a);
		for(int i=1; i<a.size(); i++) {
			assertTrue((int)a.get(i) >= (int)a.get(i-1));
		}
	}
	
	@Test
	public void test3() {
		Integer[] arr = {1, 2, 5, 2, 3, -1, 2, 1, 1, 4};
		Integer total = 4;
		List<Point> expected = new ArrayList<Point>();
		expected.add(new Point(2,2));
		expected.add(new Point(-1,5));
		expected.add(new Point(3,1));
	//	System.out.println(obj.getGroupWithTotal(arr, total));
		assertTrue(obj.getGroupWithTotal(arr, total).containsAll(expected));
		
	}
}
