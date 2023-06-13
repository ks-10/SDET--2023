package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class moveZeros {

	@Test
	public void postiveScenario() {
		int[] b = {0,1,0,3,12};
		System.out.println(Arrays.toString(solution2(b)));

	}

	@Test
	public void negativeScenario() {
		int[] b = {1,0,1};
		System.out.println(Arrays.toString(solution2(b)));
	}

	@Test
	public void EdgecaseScenario() {
		int[] b = {0,0,0,1};
		System.out.println(Arrays.toString(solution2(b)));
	}

	//--- Time complexcity ==> O(n) ---
	//--- Space complexcity ==> O(1) ----
	
	private int[] solution2(int []b) {
		//intitalizing the left and right pointer
		int left= 0; int right= 1;
		//Looping till the right pointer reaches the array length
		while(right < b.length) {
			//checking for the right pointer is non zero
			if(b[right]!=0) {
				//swapping the rigtht position with left 
				int temp = b[right];
				b[right] = b[left];
				b[left++] = temp;	
			}
			else {
				right++;
				
			}
		}
		return b;
		

	}

}
