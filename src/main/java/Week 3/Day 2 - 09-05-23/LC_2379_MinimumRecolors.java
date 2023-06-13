package dailyProblems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MinimumRecolors {

	@Test
	public void Scenario1() {
		String str = "WBBWWBBWBW";
		int k = 7;
		System.out.println(solution2(str, k));

	}

	@Test
	public void Scenario2() {
		String str = "WBWBBBW";
		int k = 2;
		System.out.println(solution2(str, k));
	}

	@Test
	public void Scenario3() {
		String str = "BBBB";
		int k = 4;
		System.out.println(solution2(str, k));
	}

	

	

	// --- Time complexcity ==> O(n*m) ---
	// --- Space complexcity ==> O(n) ----
	private int solution2(String a, int k) {
		//Intialize the variable to get the minimum value
		int minCount = Integer.MAX_VALUE;
		//intialize left=0 and right = k value
		int left = 0;
		int right = k - 1;
		//Initalize hashmap to have track of the B and W colors
		Map<Character, Integer> mp = new HashMap<>();
		
		//loop till the end of the input string
		while (right < a.length()) {
			mp.put('W', 0);
			mp.put('B', 0);
			//loop to get the count of the B & W in that particular window
			for (int i = left; i <= right; i++) {
				if (a.charAt(i) == 'W') {
					mp.put(a.charAt(i), mp.get(a.charAt(i)) + 1);
				} else {
					mp.put(a.charAt(i), mp.get(a.charAt(i)) + 1);
				}
			}
			//if the count of B == k return zero, else check for the minimum occurence of W and assign to minvalue
			if (mp.get('B') >= k) {
				return 0;
			} else {

				if (mp.get('W') < minCount) {
					minCount = mp.get('W');
				}
				left++;
				right++;

			}

		}
		//return the minimum value for the no of possible swaps
		return minCount;

	}

}
