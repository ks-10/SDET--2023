package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class maximumProduct {

	@Test
	public void postiveScenario() {
		int[] a = { 3, 4, 5, 2 };
		System.out.println(solution2(a));

	}

	@Test
	public void negativeScenario() {
		int[] a = { 4, 3, 3, 3, 3 };
		System.out.println(solution2(a));
	}

	@Test
	public void EdgecaseScenario() {
		int[] a = { 0, 0 };
		System.out.println(solution2(a));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(1) ----

	private int solution(int[] a) {
		// Using the inbuilt function to sort an array and getting the last two values
		// to perform the solution
		Arrays.sort(a);
		;
		System.out.println(Arrays.toString(a));
		return (a[a.length - 2] - 1) * (a[a.length - 2] - 1);

	}

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(1) ----

	private int solution2(int[] a) {
		// intializing the b to get the maximum product
		int b = 0;
		// Outer loop to no of elements in the array
		for (int i = 0; i < a.length; i++) {
			// inner loop to calculate the maximum product from i and i+1 values
			for (int j = i + 1; j < a.length; j++) {
				int temp = (a[i] - 1) * (a[j] - 1);
				//checking for the maximum product
				if (temp > b) {
					b = temp;
				}
			}
		}
		return b;

	}

}
