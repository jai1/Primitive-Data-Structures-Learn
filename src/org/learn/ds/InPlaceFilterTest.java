package org.learn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InPlaceFilterTest {

	@Test
	public void test() {
		assertEquals(InPlaceFilter.filter("Not yet implemented", 'e'), "Not yt implmntd");
		assertEquals(InPlaceFilter.filter(null, 'e'), "");
		assertEquals(InPlaceFilter.filter("", 'e'), "");
		assertEquals(InPlaceFilter.filter("e", 'e'), "");
		assertEquals(InPlaceFilter.filter("t", 'e'), "t");
	}

}
