package org.learn.ds;

public class BinarySearchTree <T extends Comparable>{
	/*
	 * Property:-
	 * a. Every node on the right subtree has to be larger than the current node 
	 *    and every node on the left subtree has to be smaller than 
	 *    (or equal to - should not be the case as only unique values 
	 *    should be in the tree - this also poses the question as to 
	 *    if such nodes should be left or right of this parent) the current node
	 * b. If you look at each the tree from the bottom, it looks like a sorted array
	 * Example:-
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
	 *  2   10  13   17   
	 * / \     / \   / \ 
	 * 1  8   12 14  16 18 
	 */	 
	 
	/*
	 * Traversing a Tree:-
	 * a. Pre-order[edit]
	 * 		Display the data part of root element (or current element)
	 * 		Traverse the left subtree by recursively calling the pre-order function.
	 * 		Traverse the right subtree by recursively calling the pre-order function.
	 * 	b. In-order (symmetric)[edit]
	 * 		Traverse the left subtree by recursively calling the in-order function
	 * 		Display the data part of root element (or current element)
	 * 		Traverse the right subtree by recursively calling the in-order function
	 * 	c. Post-order[edit]
	 * 		Traverse the left subtree by recursively calling the post-order function.
	 * 		Traverse the right subtree by recursively calling the post-order function.
	 * 		Display the data part of root element (or current element).
	 */
	
	/*
	 * Company:- Microsoft
	 * Question:- WAP to validate a binary tree.
	 * Soln 1:- For each node check if element left < element < element right
	 * 			Can't use this since it will give Example 1 as a valid BST
	 * Soln 2:- recursively check that the left smaller than the right  
	 * 
	 */
	private T leftValue = null;
	
	/* Using In-Order Traversal, ignore the root == null check
	 * In Order traversal ensures that the leftValue  always contains the value
	 * immediately to the left of the node. 
	 * This helps validate property b of the BTree
	 */   
	public boolean validateBST(BTNode<T> root) {
		if(root == null) 
			return true;

		if(!validateBST(root.left))
			return false;
		
		// root < leftValue
		if(leftValue != null && root.data.compareTo(leftValue) < 0)
			return false;
		
		leftValue = root.data;
		
		return validateBST(root.right);
	}	
	
	/*
	 * Company: VMWare
	 * Question: Convert SORTED array to a BALANCED binary tree 
	 *           and return the root Node.
	 */
	public BTNode<T> cnvtSortedArrayToBalBST(T[] arr) {
		return cnvtSortedArrayToBalBSTHelper(arr, 0, arr.length - 1);
		
	}

	private BTNode<T> cnvtSortedArrayToBalBSTHelper(T[] arr, int start, int end) {
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		BTNode<T> node = new BTNode<T>(arr[mid]);
		node.left = cnvtSortedArrayToBalBSTHelper(arr, start, mid - 1);
		node.right = cnvtSortedArrayToBalBSTHelper(arr, mid + 1, end);
		return node;
	}
}
