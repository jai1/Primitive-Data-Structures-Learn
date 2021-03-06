package org.learn.ds;

import java.util.List;

public class BinaryTree <T extends Comparable>{
	/*
	 * Company: Stub Hub 
	 * Question:- Find the common ancestor between, two nodes.
	 * Logic: 
	 */
	public BTNode commonAncestor(BTNode root, BTNode p, BTNode q) {
		if(root == null)
			return null;
		if( root.equals(p) || root.equals(q))
			return root;
		
		BTNode l = commonAncestor(root.left, p, q);
		BTNode r = commonAncestor(root.right, p, q);
		
/*		System.out.println("=====================================");
		System.out.println("root=" + root);
		System.out.println("l=" + l);
		System.out.println("r=" + r);
		System.out.println("=====================================");
*/		
		if(l != null && r != null)
			return root;
		else if(l != null)
			return l;
		return r;
	}
}

