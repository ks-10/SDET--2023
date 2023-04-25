package dailyProblems;

import java.util.Iterator;

import org.junit.Test;

public class addDigits {

	@Test
	public void postiveScenario() {
		int b = 18;
		System.out.println(solution(b));

	}

	// @Test
	public void negativeScenario() {
		int b = -89;
		System.out.println(solution(b));
	}

	// @Test
	public void EdgecaseScenario() {
		int b = 0; // or 9
		System.out.println(solution(b));
	}
	

	// Time complexcity ==> O(n^2)
	// Space complexcity ==> O(1)
	private int solution(int b) {
		int sum = 0;
		if (b == 0 || b <= 9) {
			return b;
		} else {
			do {
				while (b != 0 || sum > 9) {
					if (b != 0) {
						sum += b % 10;
						b = b / 10;
					} else {
						b = sum;
						sum = 0;
						sum += b % 10;
						b = b / 10;
					}
				}

			} while (findlen(sum) != 1);

			return sum;
		}

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
