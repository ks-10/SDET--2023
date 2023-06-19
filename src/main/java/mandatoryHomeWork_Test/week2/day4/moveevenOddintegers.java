package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class moveevenOddintegers {

	// @Test
	public void postiveScenario() {
		int[] b = { 3, 1, 2, 4 };
		System.out.println(Arrays.toString(solution2(b)));

	}

	// @Test
	public void negativeScenario() {
		int[] b = { 0, 1, 2 };
		System.out.println(Arrays.toString(solution2(b)));
	}

	@Test
	public void EdgecaseScenario() {
		int[] b = { 0 };
		System.out.println(Arrays.toString(solution2(b)));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(1) ----

	private int[] solution2(int[] b) {
		// Initialize the pointers left=0 and right = end of the array
		int left = 0;
		int right = b.length - 1;
		while (left < right) {
			// check whether the left value is even if even increment the left
			while (left < right && b[left] % 2 == 0) {
				left++;
			}
			// check whether the right value is odd, if odd decrement the right
			while (left < right && b[right] % 2 == 1) {
				right--;
			}
			// if left=odd or right =even swap the positions and increment the left ,
			// decrement the right
			if (b[left] % 2 == 1 || b[right] % 2 == 0) {
				int temp = b[right];
				b[right] = b[left];
				b[left] = temp;
				left++;
				right--;
			}

		}
		return b;

	}

}
