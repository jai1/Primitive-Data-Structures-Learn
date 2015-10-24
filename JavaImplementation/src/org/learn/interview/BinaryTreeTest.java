package org.learn.interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
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
	BinaryTree<Float> b = null;
	BTNode<Float> root = null;
	@Before
	public void setUp() throws Exception {
		b = new BinaryTree<Float>();
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

}
