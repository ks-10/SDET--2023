package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class removeDuplicates {

	@Test
	public void postiveScenario() {

		int[] b = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(solution(b));

	}

	 @Test
	public void negativeScenario() {
		int[] b = {  0, 1 };
		System.out.println(solution(b));
	}

	 @Test
	public void EdgecaseScenario() {
		int[] b = { 0, 0 };
		System.out.println(solution(b));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----

	private int solution(int[] b) {
		// Initalizing K for getting the count of the non duplicates
		int k = 1;
		int[] op = new int[b.length];
		// Looping the input and getting the count of the non duplicates
		for (int i = 1; i < b.length; i++) {
			if (b[i] != b[i - 1]) {
				op[k] = b[i];
				k++;
			}

		}
		// printing the new array without duplicates
		System.out.println(Arrays.toString(op));

		
//	        for (int i = 0; i < k; i++) {
//	        	System.out.println(b[i] +" " + op[i]);
//	            assert b[i] == op[i];
//	        }
		return k;

	}

}
