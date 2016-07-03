package org.learn.ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void removeDupTest_1() {
		LinkedListNode n = new LinkedListNode(10);
		n.nextNode = new LinkedListNode(10);
		n.nextNode.nextNode = new LinkedListNode(10);
		n.nextNode.nextNode.nextNode = new LinkedListNode(10);
		n = LinkedList.removeDuplicates(n);
		assertEquals(LinkedList.toString(n) , "10");
	}

	@Test
	public void removeDupTest_2() {
		assertEquals(LinkedList.removeDuplicates(null), null);
	}
	
	@Test
	public void removeDupTest_3() {
		LinkedListNode n = new LinkedListNode(10);
		n = LinkedList.removeDuplicates(n);
		assertEquals(LinkedList.toString(n) , "10");
	}

	@Test
	public void removeDupTest_4() {
		LinkedListNode n = new LinkedListNode(2);
		n.nextNode = new LinkedListNode(3);
		n.nextNode.nextNode = new LinkedListNode(3);
		n.nextNode.nextNode.nextNode = new LinkedListNode(2);
		n = LinkedList.removeDuplicates(n);
		assertEquals(LinkedList.toString(n) , "3->2");
	}
	
	@Test
	public void removeDupTest_5() {
		LinkedListNode n = new LinkedListNode(2);
		n.nextNode = new LinkedListNode(3);
		n.nextNode.nextNode = new LinkedListNode(5);
		n = LinkedList.removeDuplicates(n);
		assertEquals(LinkedList.toString(n) , "2->3->5");
	}
}
