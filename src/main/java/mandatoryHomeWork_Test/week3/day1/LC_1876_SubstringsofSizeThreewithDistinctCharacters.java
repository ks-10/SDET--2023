package dailyProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SubstringsofSizeThreewithDistinctCharacters {

	@Test
	public void Scenario1() {
		String str= "aababcabc";
		System.out.println(solution2(str));

	}

	@Test
	public void Scenario2() {
		String str= "xyzzaz";
		System.out.println(solution(str));
	}

	@Test
	public void Scenario3() {
		String str= "aaaa";
		System.out.println(solution(str));
	}

	//--- Time complexcity ==> O(n) ---
	//--- Space complexcity ==> O(1) ----
	
	private int solution(String a) {
		int op =0;
		//Intitalize the pointer
		int left=0;
		//Loop till length-3 since we need to check 3 subarrays 
		while(left<a.length()-2) {
			//checking for the possible conditions whether there is any duplicate, If yes increment the pointer , If no increment the pointer and output count
				if(a.charAt(left)==a.charAt(left+1)||a.charAt(left)==a.charAt(left+2) || a.charAt(left+1)==a.charAt(left+2)) {
					left++;
				}
				else {
					left++;
					op++;
				}
				
			}

		return op;
		
	}
	
	//--- Time complexcity ==> O(n * m) ---
	//--- Space complexcity ==> O(1) ----
	private int solution2(String a) {
		int op =0;
		int left=0;
		//Adding to a set and check the size is 3 and adding the count of the output
		Set<Character> op1 = new HashSet<>();
		while(left<a.length()-2) {
			for (int i = left; i < left+3; i++) {
				op1.add(a.charAt(i));
			}
			if(op1.size()==3) {
				op1.removeAll(op1);
				left++;
				op++;
			}
			else {
				op1.removeAll(op1);
				left++;
			}
		}
		return op;
		
	}
}
