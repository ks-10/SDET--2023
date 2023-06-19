package dailyProblems_String;

import org.junit.Test;

public class IsSubsequence {
	@Test
	public void data() {
		String str = "acb";
		String str1 = "ahbgdc";
		System.out.println(isSub1(str, str1));
	}

	// @Test
	public void data1() {
		String str = "axc";
		String str1 = "ahbgdc";
		System.out.println(isSub(str, str1));
	}

	// @Test
	public void data2() {
		String str = "abc";
		String str1 = "abcde";
		System.out.println(isSub(str, str1));
	}

	//Time complexity --> O(n)
	//Space complexity --> O(1)
	private boolean isSub(String str, String str1) {
		//Checking if the str1.length is less if yes return false 
		if (str1.length() < str.length()) {
			return false;
		}
		//Init the pointers to traverse from start of the both string
		int left = 0;
		int right = 0;
		//loop till the end of the string
		while (left < str.length() && right < str1.length()) {
			//check if the left matches the right if yes increment both pointers
			if (str.charAt(left) == str1.charAt(right)) {
				left++;
				right++;
			//else increment only the right	
			} else if (str.charAt(left) != str1.charAt(right)) {
				right++;
			//if left is equal to length of str return true	
			} else if (left == str.length()) {
				break;
			}

		}

		return left == str.length();
	}

	private boolean isSub1(String str, String str1) {
		if (str1.length() < str.length()) {
			return false;
		}
		int count = 0;
		int left = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = left; j < str1.length(); j++) {
				if (str.charAt(i) == str1.charAt(j)) {
					count++;
					left = j + 1;

				}
			}
		}

		return count == str.length();
	}
}
