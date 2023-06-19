package dailyProblems;

import org.junit.Test;

public class KBeautyOfNum {

	@Test
	public void data() {
		int a = 240;
		int k = 2;
		System.out.println("K beauty is : " + solution(a, k));

	}

	@Test
	public void data1() {
		int a = 10;
		int k = 1;
		System.out.println("K beauty is : " + solution(a, k));

	}

	@Test
	public void data2() {
		int a = 43000043;
		int k = 2;
		System.out.println("K beauty is : " + solution(a, k));

	}

	//Time complexity = O(n)
	//Space complexity = O(n)
	public int solution(int a, int k) {
		int count = 0;
		//converting int to String and storing it in variable
		String b = String.valueOf(a);
		//intializing left=0 and right=k pointer 
		int left = 0;
		int right = k;
		//looping till the end of the array
		while (right <= b.length()) {
			int out = -1;
			//Getting the numbers of given window size
			String op = b.substring(left, right);
			//checking if the given window variables is greater than zero as ) cannot be divided
			if (Integer.parseInt(op) > 0) {
				//calculating whether the reminder is 0 if Yes incrementing the counter else incrementing the left and right pointers
				out = a % Integer.parseInt(op);
				if (out == 0) {
					count++;
				}
			}
			left++;
			right++;
		}

		return count;

	}

}
