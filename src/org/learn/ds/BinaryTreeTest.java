package org.learn.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	BinaryTree bt = new BinaryTree();
	BTNode<Integer> root = new BTNode<Integer>(7);
	@Before
	public void setUp() throws Exception {
		root.left = new BTNode<Integer>(4);
		root.right = new BTNode<Integer>(9);
		
		root.left.left= new BTNode<Integer>(2);
		root.left.right= new BTNode<Integer>(6);
		
		root.left.left.left= new BTNode<Integer>(1);
		root.left.left.right= new BTNode<Integer>(3);
		
		root.left.right.left= new BTNode<Integer>(5);	
		
		root.right.left = new BTNode<Integer>(8);	
	}

	@Test
	public void test_1() {
		BTNode<Integer> a = new BTNode<Integer>(8);
		BTNode<Integer> b = new BTNode<Integer>(3);
		
		BTNode<Integer> result = bt.commonAncestor(root, a, b);
		assertEquals(result.data, (Integer)7);
	}
	
	@Test
	public void test_2() {
		BTNode<Integer> a = new BTNode<Integer>(1);
		BTNode<Integer> b = new BTNode<Integer>(6);
	
		BTNode<Integer> result = bt.commonAncestor(root, a, b);
		assertEquals(result.data, (Integer)4);
	
	}
}