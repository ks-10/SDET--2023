package learnings;

import java.util.Arrays;

import org.junit.Test;



public class hayStackandNeedle {
	
	/*
	 * positive data  : haystack = "sadbutsad"
	 * edge case data : haystack = "Hello World" needle = "w" (or) haystack = "sasad"  needle = "sad"
	 * negative data : haystack = "" needle = "he"  or haystack = "Hello" needle = ""
	 * 
	 * 
	 * pseudocode:
	 * 1. convert the string to either upper or lower case 
	 * 2. verify the given string is null, if it is null return -1
	 * 3. Check the given needle string is available in haystack
	 * 		a. if yes return the first occurring index
	 * 		b. if no return -1 
	 * */

	@Test
	public void data() {
		String haystack = "mississippi";
		String needle = "issip";
		System.out.println(solution3(haystack, needle));

	}


	private int solution1(String haystack, String needle) {
		//haystack = haystack.toLowerCase();
		//needle = needle.toLowerCase();
		
		if (haystack.isEmpty() || needle.isEmpty()) {
			return -1;
		}
		else if(haystack.contains(needle)) {
			return haystack.indexOf(needle);
		}
		else {return -1;}
		
	}


	/*
	 * positive data  : haystack = "sadbutsad"
	 * edge case data : haystack = "Hello World" needle = "w" (or) haystack = "sasad"  needle = "sad"
	 * negative data : haystack = "" needle = "he"  or haystack = "Hello" needle = ""
	 * 
	 * 
	 * pseudocode:
	 * 1. convert the string to either upper or lower case 
	 * 2. verify the given string is null, if it is null return -1
	 * 3. Check the given needle string is available in haystack
	 * 		a. if yes iterate the possible needle string in haystack and if found a match return the index of the first char 
	 * 		b. if no return -1 
	 * */
	
	private int solution2(String haystack, String needle) {
		haystack = haystack.toLowerCase();
		needle = needle.toLowerCase();
		int hL = haystack.length();
		int nL = needle.length();

		int out = -1;
		if (haystack.isEmpty() || needle.isEmpty()) {
			return out;
		} else if (haystack.contains(needle)) {
			for (int i = 0; i < hL - nL; i++) {
				int j = 0;

				for (j=0; j < nL; j++) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					}
				}
				if (j == nL) {
					out = i;
				}
			}
		} else {
			return -1;
		}
		return out;
	}
	
	
	private int solution3(String haystack, String needle) {
		int size  =  needle.length();
		
		for (int i = 0; i < haystack.length() - size; i++) {
			if(haystack.substring(i, i+size).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

}