package dailyProblems;

import java.util.Iterator;

import org.junit.Test;

public class powerOfTwo {

	@Test
	public void postiveScenario() {
		int b = 1;
		System.out.println(solution(b));

	}

	 @Test
	public void negativeScenario() {
		int b = -89;
		System.out.println(solution(b));
	}

	@Test
	public void EdgecaseScenario() {
		int b = 0; // or 9
		System.out.println(solution(b));
	}
	

	// Time complexcity ==> O(log n)
	// Space complexcity ==> O(log n)
	private boolean solution(int b) {
		if(b==1) {
			return true;
		}
		else if(b>0){
			if(b%2==0 && solution(b/2)) {
				return true;
			}
		}
		return false;
		
		

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
