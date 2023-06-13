package dailyProblems;

import org.junit.Test;

public class missingNumber {

	@Test
	public void postiveScenario() {
		int[] b = { 0, 1, 2, 3,5, 4, 6, 7, 8,9,10,11,12,14 };
		System.out.println(solution(b));
	}

	@Test
	public void negativeScenario() {
		int[] b = { 0, 1 };
		System.out.println(solution(b));
	}

	@Test
	public void EdgecaseScenario() {
		int[] b = { 0,1,2,3,4,5 };
		System.out.println("Edge case" +solution(b));
	}

	// Time complexcity ==> O(n^2)
	// Space complexcity ==> O(n)
	private int solution(int[] a) {
		int len = findlen(a);
		int[] b = new int[len + 1];

		arraySort(a);
		b[0] = 0;
		for (int i = 0; i < len; i++) {
			b[i + 1] = b[i] + 1;
		}

		for (int i = 0; i < b.length; i++) {
			try {
				if (b[i] != a[i]) {
					return b[i];
				}

			} catch (Exception e) {
				return b[i];
			}

		}
		return 0;

	}

	// time complexcity ==> O(logn)
	private int findlen(int x) {
		int len = 0;
		while (x != 0) {
			x = x / 10;
			++len;
		}
		System.out.println("Length : " + len);
		return len;

	}

	//Time complexity is O(n^2)
	private int[] arraySort(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int tmp = 0;
				if (a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}

	private int findlen(int[] x) {
		int len = 0;
		for (int i = 0; i < x.length; i++) {
			len++;
		}
		// System.out.println("Length : " + len);
		return len;

	}

	private void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				System.out.print("[" + a[i] + ",");
			} else if (i == a.length - 1) {
				System.out.print(a[i] + "]");
			} else
				System.out.print(a[i] + ",");

		}
	}

}
