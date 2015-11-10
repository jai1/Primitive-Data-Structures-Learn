package org.learn.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchAndSortAlgos<T extends Comparable> {
	
	public void  mergeSort(List<T> lst) {
		if(lst == null)
			return;
		
		// Sort
		divideAndSort(lst, 0, lst.size()-1);
	}
	
	
	
	
	private void divideAndSort(List<T> lst, int beg, int end) {
		if(beg>=end)
			return;
		
		int mid = (beg + end) / 2;
		
		//Divide
		divideAndSort(lst, beg, mid);
		divideAndSort(lst, mid+1, end);
		
		// Merge
		merge(lst, beg, mid, end);
		
	}




	private void merge(List<T> lst, int beg, int mid, int end) {
		List<T> tmp = new ArrayList<T>();
		
		for(int i=beg; i<=end; i++) 
			tmp.add(lst.get(i));

		/*System.out.println("+++++++++++++ENTER+++++++++++++++++++");
		System.out.println(lst);
		System.out.println(tmp);
		System.out.println("beg=" + beg + ", mid=" + mid + ", end=" + end);
		System.out.println("++++++++++++++++++++++++++++++++++++");
		*/
		int j = 0;
		int k = mid + 1 - beg;
		for(int i=beg; i<=end; i++) {
			/*System.out.println("i=" + i + ", j=" + j + ", k=" + k);*/
			if(j<=mid - beg) {
				if(k<=end - beg) {
					if(tmp.get(j).compareTo(tmp.get(k)) > 0) {
						lst.set(i, tmp.get(k));
						k++;
						continue;
					}
				} 
				lst.set(i, tmp.get(j));
				j++;
			} else if (k<=end - beg) {
				lst.set(i, tmp.get(k));
				k++;
			}
		}

		/*System.out.println("+++++++++++++EXIT+++++++++++++++++++");
		System.out.println(lst);
		System.out.println(tmp);
		System.out.println("beg=" + beg + ", mid=" + mid + ", end=" + end);
		System.out.println("++++++++++++++++++++++++++++++++++++");	
		*/
	}

	/*
	 * Company: Yahoo
	 * Question:- Given a sorted array (asc order) find an element
	 *  
	 */
	public Integer binarySearch(T[] arr, T element) {
		if(arr == null || element == null || arr.length == 0)
			return -1;
		
		Integer start = 0;
		Integer end = arr.length - 1;
		while(start <= end) {
			Integer mid = (start + end) / 2;
			/*System.out.println(start+ ","+ mid+","+ end);*/
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
	
	/*
	 * Company:- Bloomberg
	 * Question:- Given an array of Integers find the pairs
	 * whose value = X
	 * Example:- 
	 * array => {1, 2, 5, 2, 3, -1, 2, 1, 1, 4}
	 * X = 4
	 * O/P => (2, 3) (2, 2) (5, -1) 
	 */
	
	List<Point> getGroupWithTotal(Integer[] a, Integer total) {
		if(a==null||total==null)
			return null;
		List<Point> lop = new ArrayList<Point>();
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i = 0; i<a.length; i++) {
			if(m.containsKey(total - a[i]) && m.get(total - a[i]) > 0) {
				m.put(total - a[i], m.get(total - a[i]) - 1);
				lop.add(new Point(a[i], total - a[i]));
				continue;
			}
			if(m.containsKey(a[i])) 
				m.put(a[i], m.get(a[i]) + 1);
			else
				m.put(a[i], 1);
		}
		
		
		return lop;
	}
	

}
