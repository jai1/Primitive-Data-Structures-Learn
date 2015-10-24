package org.learn.interview;
public class InPlaceFilter {
	/*
	 * Company:- Google
	 * Question:- Filter out the given character from a string.
	 * Example:- filter("jaaaaai", "a") => "ji"
	 * Note:- Need to use stringbuilder since String in Jaa is immutable hence no InPlace.
	 */
	
	public static String filter(String i_str, char ch) {
		
		if(i_str == null || i_str.equals(""))
			return "";
		StringBuilder str = new StringBuilder(i_str);
		int counter = 0;
		int i = 0;
		while(i + counter < str.length()) {
			if(str.charAt(i + counter) == ch ) {
				counter++;
				continue;
			}
			str.insert(i, str.charAt(i+counter));
			str.deleteCharAt(i+1);			
			i++;
		}
		while(i-counter<str.length()) {
			str.deleteCharAt(i);
			counter--;
		}
		return new String(str);		
	}
	
	/* Company: None
	 * Question:- Inplace substring method
	 * 
	 */
}

