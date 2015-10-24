package org.learn.interview;

public class LinkedList {	
	static String toString(LinkedListNode head) {
		String str = "";
		while(head != null) {
			str += head.val + "->";
			head = head.nextNode;
		}
		if(str.length() == 0)
			return "";
		return str.substring(0, str.length() - 2);
	}
	
	/*
	 * Company:- Arista
	 * Question:- Remove Duplicate from Linkedlist
	 * Example:- "2 -> 3 -> 5" => "2 -> 3 -> 5"
	 * "2 -> 3 -> 3 -> 2" => "2 -> 3"
	 *	"5" => "5"
	 *	null => null 
	 */
	static LinkedListNode removeDuplicates(LinkedListNode n) {
		if(n == null || n.nextNode == null)
			return n;
		else
			if(listContainsVal(n.val, n.nextNode)) 
				return removeDuplicates(n.nextNode);
			else {
				n.nextNode=removeDuplicates(n.nextNode);
				return n;
			}
	}
	
	static boolean listContainsVal(Integer val, LinkedListNode head) {
		while(head != null && head.val != val) 
			head = head.nextNode;
		return (head != null);		
	}
	
}
