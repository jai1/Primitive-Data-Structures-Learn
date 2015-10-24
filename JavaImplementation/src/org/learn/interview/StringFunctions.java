package org.learn.interview;

import java.util.ArrayList;
import java.util.List;

public class StringFunctions {

	/*
	 * Company:- Google, Microsoft
	 * Question:- WAP to reverse a string In place
	 * Examples:- "abc" => "cba"
	 */
	public String reverse(String in) {
		if(in == null)
			return "";
		StringBuilder input = new StringBuilder(in);
		Integer start = 0;
		Integer end = input.length() - 1;
		while(start < end) {
			char temp = input.charAt(start);
			input.setCharAt(start, input.charAt(end));
			input.setCharAt(end,temp);
			start++;
			end--;
		}
		return input.toString();
	}
	
	/*
	 * Company:- Microsoft
	 * Question:- Reverse a sentence
	 * Example:- "Jai is" => "is Jai"
	 * "Wow! This is boring." => "boring. is This Wow!"
	 */ 
	public String reverseSentence(String in) {
		if(in==null) return "";
		int k = in.indexOf(" ");
		if(k == -1)
			return in;
		else
			return reverseSentence(in.substring(k+1)) + " " + in.substring(0,k);
	}
	
	/*
	 * Company:- Sev One
	 * Question:- Number++ if input is a number else reverse the String.
	 * Example:- ".2" => "1.2"
	 * "-1.2" => "-0.2"
	 * "abc" => "cba"
	 * "" => ""
	 */
	public String reverseOrAdd(String in) {
		if(in.isEmpty())
			return "";
		if(in.matches("-?\\d*(\\.\\d+)?"))
			return Float.toString(convertToFloat(in) + 1);
		else
			return reverse(in);
	}
	
	/*
	 * Company:- Bloomberg, Microsoft
	 * Question:- write itoa or ftoa
	 * Examples:- ".2" => 0.2f
	 * "-.1" => -0.1f
	 * "-23" => -23f
	 * "-2.23" => -2.23f
	 */
	public float convertToFloat(String in) {
		float f = 0.0f;
		boolean isNegative = (in.charAt(0) == '-');
		Integer k = in.indexOf('.');
		Integer divideBy = 0;
		if(k != -1)
			divideBy =  (in.length() - 1) - k;
		for(int i = isNegative?1:0 ; i<in.length(); i++) {
			if(in.charAt(i) == '.')
				continue;
			else
				f = (f*10) + (in.charAt(i) - '0');
		}
		f = (float) (f / Math.pow(10, divideBy));
		if(isNegative)
			f *= -1;
		return f;
	}
	
	/*
	 * Company:- Avaya
	 * Question:- Given a 2D Array of characters, find if the 
	 * 			  given word can be formed i.e each character is
	 * 			  adjacent to each other and used exactly once.
	 * Example:-	["ABCAE"]
	 * 				["CERTA"]
	 * 				["PILOC"]
	 * 
	 * "CERTO" => true
	 * "ABCT" => false
	 * "ATOLRECABC" => true 
	 * "ATOLRECABCA" => false 
	 * "ATOLRECABCRTA" => true 
	 */
	boolean boardContainsWord(char[][] board, String word){
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Word is " + word);
		List<Point> trailSoFar = new ArrayList<Point>();
		for(int i = 0; i<board.length; i++) {
			for(int j =0; j<board[i].length; j++) {
				Point p = new Point(i,j);
				if(boardContainsWordHelper(board, word, p, trailSoFar, 0, null))
					return true;
			}
		}
		System.out.println("++++++++++++++++++++++++++++++++");
		return false;
	}

	
	/*
	 * Need visited array since its DFS and we don't want go in 
	 * circles, also visited is not for entire word. It is only 
	 * valid for that letter.
	 * Need trailSoFar because if we used a letter before, we are 
	 * not allowed to use it again. 
	 */
	
	private boolean boardContainsWordHelper(char[][] board, String word, Point p, List<Point> trailSoFar, int i, List<Point> visited) {
		
		if(visited == null)
			visited = new ArrayList<Point>();
		
		if(i>=word.length())
			return true;
		
		
		if( i<0 ||
			p.x < 0 || p.y<0 ||
			p.x >= board.length || p.y >= board[p.x].length ||
			trailSoFar.contains(p) ||
			visited.contains(p) ||
			word.charAt(i) != board[p.x][p.y] )
			return false;
		

		trailSoFar.add(p);
		visited.add(p);
		System.out.println(trailSoFar);
		i+=1;
		return ((boardContainsWordHelper(board, word, new Point(p.x+1,p.y), trailSoFar, i, null)) ||
				(boardContainsWordHelper(board, word, new Point(p.x-1,p.y), trailSoFar, i, null)) ||
				(boardContainsWordHelper(board, word, new Point(p.x,p.y+1), trailSoFar, i, null)) ||
				(boardContainsWordHelper(board, word, new Point(p.x,p.y-1), trailSoFar, i, null)) ||
				((trailSoFar.remove(p)) &&
				(boardContainsWordHelper(board, word, p, trailSoFar, --i,visited ))));
	}
}
