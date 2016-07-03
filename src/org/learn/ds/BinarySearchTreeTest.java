package org.learn.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	/*	 * Example:-
	 * 1. Not a BST (Because of 13)
	 *	 	 10               
	 *       / \       
	 *      /   \      
	 *     /     \     
	 *    /       \    
	 *    9       15       
	 *   / \      / \   
	 *  /   \    /   \  
	 *  2   10  13   16   
	 * / \     / \  / \ 
	 * 1 13   12 14  15 18
	 * 
	 * 2. A BST         
	 *	 	 10               
	 *       / \       
	 *      /   \      
	 *     /     \     
	 *    /       \    
	 *    9       15       
	 *   / \      / \   
	 *  /   \    /   \  
	 *  2   10  13   16   
	 * / \     / \  / \ 
	 * 1  8   12 14 15 18 
	 */	 
	BinarySearchTree<Float> b = null;
	BTNode<Float> root = null;
	@Before
	public void setUp() throws Exception {
		b = new BinarySearchTree<Float>();
	}

	private void createTree() {
		root = new BTNode(10.0f);
		
		root.left = new BTNode(9f);
		root.right = new BTNode(15f);
		
		root.left.left = new BTNode(2f);
		root.left.right = new BTNode(10f);
		root.right.left = new BTNode(13f);
		root.right.right = new BTNode(17f);
		
		root.left.left.left = new BTNode(1f);
		root.left.left.right = new BTNode(13f);
		root.right.left.left = new BTNode(12f);
		root.right.left.right = new BTNode(14f);		
		root.right.right.left = new BTNode(16f);
		root.right.right.right = new BTNode(18f);
		
	}

	@Test
	public void test1() {
		createTree();
		
		assertFalse(b.validateBST(root));
	}


	@Test
	public void test2() {
		createTree();
		root.left.left.right = new BTNode(8f);
		assertTrue(b.validateBST(root));
	}

	@Test
	public void test3() {
		Float[] arr = {-1f, 1f, 2f, 4f, 5f, 10f, 100f, 200f, 301f};
		BTNode n = b.cnvtSortedArrayToBalBST(arr);
		assertEquals(n.data, 5f);
		
		assertEquals(n.left.data, 1f);
		assertEquals(n.right.data, 100f);
		
		assertEquals(n.left.left.data, -1f);
		assertEquals(n.left.right.data, 2f);
		assertEquals(n.right.left.data, 10f);
		assertEquals(n.right.right.data, 200f);
		
		assertEquals(n.left.right.right.data, 4f);
		assertEquals(n.right.right.right.data, 301f);
	}
}
