package dailyProblems;

import org.junit.Test;

public class reverseEachWord {

	@Test
	public void scenario1() {
		String s1 = "Let's take LeetCode contest";
		System.out.println(solution1(s1));

	}

	@Test
	public void scenario2() {
		String s1 = "God Ding";
		System.out.println(solution(s1));
	}

	@Test
	public void scenario3() {
		String s1 = "abcd";
		System.out.println(solution(s1));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----
	private String solution(String s1) {
		//creating a output string
		StringBuilder sb = new StringBuilder();
		//spliting the array with spaces
		String[] split = s1.split(" ");

		//looping through all the splited string arrays
		for (int i = 0; i < split.length; i++) {
			char[] ch = split[i].toCharArray();
			//Looping from the reverse order for the particular array and appending it to output string
			for (int j = ch.length - 1; j >= 0; j--) {
				sb.append(ch[j]);
			}
			//manually appending the space after each array
			sb.append(" ");
		}
		//removing the space for last index
		sb.replace(sb.length() - 1, sb.length(), "");
		return sb.toString();

	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----
	private String solution1(String s1) {
		char[] ch = s1.toCharArray();
		int left = 0;
		int right = 0;
		//looping till end of the String
		while (right < ch.length) {
			//loop until you see space
			if (ch[right] != ' ') {
				right++;
			//assign the right pointer to temp variable
			//assign the left pointer to start of the word and swap it 	
			} else {
				int tempL = left, tempR = right - 1;
				while (tempL < tempR) {
					char temp = s1.charAt(tempR);
					ch[tempR--] = ch[tempL];
					ch[tempL++] = temp;
				}
				//assigning the left to value after space
				left = right + 1;
				right++;
			}
		}
		//reversing the last part of the string or String without space
		right = ch.length - 1;
		while (left < right) {
			char temp = s1.charAt(right);
			ch[right--] = ch[left];
			ch[left++] = temp;
		}

		return new String(ch);

	}

}
