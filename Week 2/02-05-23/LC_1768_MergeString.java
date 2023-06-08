package dailyProblems;

import org.junit.Test;

public class mergeString {

	@Test
	public void scenario1() {
		String s1 = "abc";
		String s2 = "pqr";
		System.out.println(solution2(s1, s2));

	}

	@Test
	public void scenario2() {
		String s1 = "abcdef";
		String s2 = "pqr";
		
		//String s1 = "abc";
		//String s2 = "pqrstu";
		System.out.println(solution2(s1, s2));
	}

	@Test
	public void scenario3() {
		String s1 = "abc";
		String s2 = "pqrs";
		System.out.println(solution2(s1, s2));
	}

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(n) ----
	private String solution(String s1, String s2) {
		//create new string for the merged string
		StringBuilder sb = new StringBuilder();
		
		//loop first string and append the char to i postion in the new string
		for (int i = 0; i < s1.length(); i++) {
			sb.append(s1.charAt(i));
			//loop second string and append the char to the new position
			for (int j = i; j < s2.length(); j++) {
				//if the second string length is greater than 1 append the remaining char at end
				if(j>=s1.length()-1) {
					sb.append(s2.charAt(j));
				}
				else {
					sb.append(s2.charAt(j));
					break;
				}
			}
		}
		
		return sb.toString();

	}
	
	private String solution2(String s1, String s2) {
		//create new string for the merged string
		StringBuilder sb = new StringBuilder();
		
		int top =0;
		int bottom=0;
		
			if(s1.length()==s2.length()) {
				while(top<s1.length()) {
				sb.append(s1.charAt(top++));
				sb.append(s2.charAt(bottom++));
				
				}
			}
			else if(s1.length()>s2.length()) {
				while(top<s2.length()) {
					sb.append(s1.charAt(top++));
					sb.append(s2.charAt(bottom++));
					
				}
				while(top<s1.length()) {
				sb.append(s1.charAt(top++));
				
				}
			}
			else if(s1.length()<s2.length()) {
				while(bottom<s1.length()) {
					sb.append(s1.charAt(top++));
					sb.append(s2.charAt(bottom++));
					
				}
				while(bottom<s2.length()) {
				sb.append(s2.charAt(bottom++));
				
				}
			}
		
		System.out.println(sb.toString());
		
		return sb.toString();

	}

}
