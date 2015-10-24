package org.learn.interview;

public class SortingAlgorithms {
	
	/*
	 * Company: Yahoo
	 * Question:- Given a sorted array (asc order) find an element
	 *  
	 */
	public <T extends Comparable> Integer binarySearch(T[] arr, T element) {
		if(arr == null || element == null || arr.length == 0)
			return -1;
		
		Integer start = 0;
		Integer end = arr.length - 1;
		while(start <= end) {
			Integer mid = (start + end) / 2;
			System.out.println(start+ ","+ mid+","+ end);
			// element in lower half
			if(element.compareTo(arr[mid]) < 0)
				end = mid - 1;
			else if(element.compareTo(arr[mid]) > 0)
				start = mid + 1;
			else 
				return mid;
		}
		return -1;
		
	}
	

}
