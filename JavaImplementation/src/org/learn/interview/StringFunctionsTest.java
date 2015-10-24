package org.learn.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringFunctionsTest {
	StringFunctions obj = null;
	@Before
	public void setUp() throws Exception {
		obj = new StringFunctions();
	}

	@Test
	public void reverseStringTest() {
		assertEquals(obj.reverse("Jai is bored"), "derob si iaJ");
		assertEquals(obj.reverse("Jai"), "iaJ");
		assertEquals(obj.reverse("abcd"), "dcba");
	}
	
	@Test
	public void reverseSentenceTest() {
		assertEquals(obj.reverseSentence(null), "");
		assertEquals(obj.reverseSentence("abc"), "abc");
		assertEquals(obj.reverseSentence("Wow! This is boring."), "boring. is This Wow!");
	}

	@Test
	public void convertToFloatTest() {
		assertEquals(obj.convertToFloat(".2"), 0.2, 0.1);
		assertEquals(obj.convertToFloat("-.1"), -0.1, 0.1);
		assertEquals(obj.convertToFloat("-23"), -23, 0.1);
		assertEquals(obj.convertToFloat("2.23"), 2.23, 0.1);
	}
	
	@Test
	public void reverseOrAddTest() {
		assertEquals(obj.reverseOrAdd(".2"), "1.2");
		assertEquals(obj.reverseOrAdd("-.1"), "0.9");
		assertEquals(obj.reverseOrAdd("-23"), "-22.0");
		assertEquals(obj.reverseOrAdd("2.23"), "3.23");
		assertEquals(obj.reverseOrAdd("jai"), "iaj");
		assertEquals(obj.reverseOrAdd("-1,2"), "2,1-");
		assertEquals(obj.reverseOrAdd("-1 "), " 1-");
	}
	
	@Test
	public void boardContainsWordTest() {
		char[][] board = {{'A', 'B', 'C', 'A', 'E'}
						, {'C', 'E', 'R', 'T', 'A'}
						, {'P', 'I', 'L', 'O', 'C'}};
		assertTrue(obj.boardContainsWord(board, "CERTO"));
		assertFalse(obj.boardContainsWord(board, "ABCT"));
		assertTrue(obj.boardContainsWord(board, "ATOLRECABC"));
		assertTrue(obj.boardContainsWord(board, "ATOLRECABCA"));
		assertFalse(obj.boardContainsWord(board, "ATOLRECABCAA"));
		
		assertTrue(obj.boardContainsWord(board, "ATOLRECPI"));
	}
	
}

