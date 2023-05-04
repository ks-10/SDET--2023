package dailyProblems;

import org.junit.Test;

public class reverseStringatChar {

	@Test
	public void scenario1() {
		String s1 = "abcdefghijklmnopqrstuv";
		char s2 = 'v';
		System.out.println(solution2(s1, s2));

	}

	@Test
	public void scenario2() {
		String s1 = "xyxzxe";
		char s2 = 'z';
		System.out.println(solution2(s1, s2));
	}

	@Test
	public void scenario3() {
		String s1 = "abcd";
		char s2 = 'z';
		System.out.println(solution2(s1, s2));
	}

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(n) ----
	private String solution(String s1, char s2) {
		StringBuilder sb = new StringBuilder();
		// intializing a left pointer to traverse throught the String length to find the
		// first occurence of the given char
		int left = 0;
		// looping till the String length
		while (left <= s1.length() - 1) {
			// if string contains char
			if (s1.charAt(left) == s2) {
				// loop till the char found, reverse and add it to the new string
				for (int i = left; i >= 0; i--) {
					sb.append(s1.charAt(i));
				}
				// add the remining left over in the array without reversing it
				for (int i = left + 1; i < s1.length(); i++) {
					sb.append(s1.charAt(i));
				}
				// return the reversed output String
				return sb.toString();
			}
			// if not found increment the left pointer
			else {
				left++;
			}
		}

		return s1;

	}

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(n) ----
	private String solution2(String s1, char s2) {
		// Get the index of the char given using in built function
		int len = s1.indexOf(s2);
		char[] ch = s1.toCharArray();
		// Intialize left=start and right = index of the char value
		int left = 0, right = len;
		// Loop till the char value and swap it
		while (left < right) {
			char temp = ch[right];
			ch[right--] = ch[left];
			ch[left++] = temp;
		}
		// return the output string
		return new String(ch);

	}
}
