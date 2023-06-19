package dailyProblems;

import java.util.Iterator;

import org.junit.Test;

public class plusOne {

	@Test
	public void data() {
		int a[] = {8,9,9};

		// /int a []= {9};
		printArray(solution(a));

	}

	private int[] solution(int[] a) {

		int intNum = 0;
		int len = 0;
		for (int i = 0; i < findlen(a); i++) {
			if (i == findlen(a) - 1) {
				intNum = intNum * 10 + a[i] + 1;
			} else {
				intNum = intNum * 10 + a[i];
			}
		}
		
		int temp = 0;
		len = findlen(intNum);
		int b[] = new int[len];
		for (int i = len - 1; i >= 0; --i) {
			temp = intNum % 10;
			b[i] = temp;
			intNum = intNum / 10;
		}
		return b;

	}
	
	private int[] solution2(int[] a) {
		int[] b =  new int [findlen(a)+1];
		for (int i = findlen(a)-1; i >=0; --i) {
			if(a[i]<9) {
				a[i] = a[i] +1;
				return a;
			}
			else {
				a[i] = 0;
				b[0] =1;
			}
			
		}
		return b;

	}

	private int findlen(int x) {
		int len = 0;
		while (x != 0) {
			x = x / 10;
			++len;
		}
		//System.out.println("Length : " + len);
		return len;

	}
	
	private int findlen(int []x) {
		int len = 0;
		for (int i = 0; i < x.length; i++) {
			len++;
		}
		//System.out.println("Length : " + len);
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
