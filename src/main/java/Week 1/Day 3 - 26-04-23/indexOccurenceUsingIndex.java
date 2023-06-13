package dailyProblems;

import org.junit.Test;

public class indexOccurenceUsingIndex {

//	3. Remove all occurrence of a number which is present in the given index number
//	input = {1,2,3,4,5,1}, indexToRemove = 5
//	output = {2,3,4,5}
	
	@Test
	public void postiveScenario() {
		int[] input = { 2, 2, 3, 2, 4, 2, 2 };
		int index = 0;
		printArray(solution(input, index));

	}

	@Test
	public void negativeScenario() {
		int[] input = { 1, 2, 3, 9, 4, 5, 1 };
		int index = -3;
		printArray(solution(input, index));
	}

	@Test
	public void EdgecaseScenario() {
		int[] input = { 1 };
		int index = 0;
		printArray(solution(input, index));
	}

	// Space complexity ==>O(n)
	// time complexcity ==> O(n)
	private int[] solution(int[] a, int index) {

		if (a.length < index || index<0) {
			return a;
		}
		int indexElement = a[index];
		int temp2 = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == indexElement) {
				++temp2;
			}
		}
		int[] b = new int[a.length - temp2];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != indexElement) {
				b[j] = a[i];
				j++;
			}
		}

		return b;

	}

	private void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a.length == 1) {
				System.out.print("[" + a[i] + "]");
			} else {
				if (i == 0) {
					System.out.print("[" + a[i] + ",");
				} else if (i == a.length - 1) {
					System.out.println(a[i] + "]");
				} else {
					System.out.print(a[i] + ",");
				}
			}
		}
	}

}
