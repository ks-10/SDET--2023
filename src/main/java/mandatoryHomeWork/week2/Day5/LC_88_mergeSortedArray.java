package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class mergeSortedArray {

	@Test
	public void postiveScenario() {
		int[] a = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int b[] = { 2, 5, 6 };
		int n = 3;
		solution2(a, b, m, n);

	}

	@Test
	public void negativeScenario() {
		int[] a = { 1, 2, 3, 0, 0, 0, 0, 0 };
		int m = 3;
		int b[] = { 2, 5, 6, 8, 9 };
		int n = 5;
		solution(a, b, m, n);
	}

	@Test
	public void EdgecaseScenario() {
		int[] a = { 5 };
		int m = 1;
		int b[] = {};
		int n = 0;
		solution(a, b, m, n);
	}

	// --- Time complexcity ==> O(m+n) ---
	// --- Space complexcity ==> O(1) ----

	private void solution(int[] a, int[] b, int alen, int blen) {
        //Looping through the second array and adding it in first array
		int right = 0;
		while (right < blen) {
			a[alen++] = b[right++];

		}
		//Sorting the entire array
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

	}

	// --- Time complexcity ==> O(m+n) ---
	// --- Space complexcity ==> O(1) ----
	private void solution2(int[] a, int[] b, int m, int n) {
		//length of the first array
		int alen = m - 1;
		//length of the second array
		int blen = n - 1;
		//length of the Total array
		int k = m + n - 1;
		
		//looping when a and b is greater than zero 
		while (alen >= 0 && blen >= 0) {
			//if a>b --> adding a it from the end of the array and decrement the a len
			if (a[alen] > b[blen]) {
				a[k--] = a[alen--];
			}
			//else adding b from the end of the array
			else {
				a[k--] = b[blen--];
			}
		}
		//if there if only element in b
		while (blen >= 0) {
			a[k--] = b[blen--];
		}

		System.out.println(Arrays.toString(a));
	}
}
