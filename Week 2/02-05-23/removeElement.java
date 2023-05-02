package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class removeElement {

	@Test
	public void postiveScenario() {

		int[] b = { 0,1,2,2,3,0,4,2 };
		int remove = 2;
		System.out.println(solution(b, remove));

	}

	@Test
	public void negativeScenario() {
		int[] b = { 3, 2, 2, 3, 7, 4, 6, 7 };
		int remove = 9;
		System.out.println(solution(b, remove));
	}

	@Test
	public void EdgecaseScenario() {
		int[] b = { 0, 0 ,1};
		int remove = 0;
		System.out.println(solution(b, remove));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----

	private int solution(int[] b, int remove) {
		//intitalizing the var for inserting the value in new position
		int k = 0;
		//looping through the given input
		for (int i = 0; i < b.length; i++) {
			//if not equal to value add the values from first
			if (b[i] != remove) {
				b[k] = b[i];
				k++;
			} 

		}
		System.out.println(Arrays.toString(b));
		return k;

	}
	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----

	private int solution2(int[] a, int remove) {
		//intitalizing the var for inserting the value in new position
		int count = 0;
		//looping through the given input
		for (int i = 0; i < a.length; i++) {
			//if not equal to value swap the elements to right of the array
			if (a[i] != remove) {
				int temp = a[count];
				a[count] = a[i];
				a[i] = temp;
				count++;
			}
		}
		System.out.println(Arrays.toString(a));
		return count;

	}

}
