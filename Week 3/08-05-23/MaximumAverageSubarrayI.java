package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class MaximumAverageSubarrayI {

	@Test
	public void postiveScenario() {
		int[] b = {5};
		int k=1;
		System.out.println(solution(b,k));
	}

	 @Test
	public void negativeScenario() {
		int[] b = {6,8,6,8,0,4,1,2,9,9};
		int k=2;
		System.out.println(solution2(b,k));
	}

	 @Test
	public void EdgecaseScenario() {
		int[] b = {1,12,-5,-6,50,3};
		int k=4;
	}

	// --- Time complexcity ==> O(n*k) ---
	// --- Space complexcity ==> O(1) ----

	private double solution(int[] b,int k) {
		//intialize the left pointer
		int left=0;
		//assign the minimum integer value to calc the average
		double maxAvg=Integer.MIN_VALUE;
		//Loop till the last length-K
		while(left<=b.length-k) {
			double sum=0;
			//loop to calc the sum of the K values in subarray
			for (int i = left; i < left+k; i++) {
				sum += b[i];
			}
			//validating whether new avg is greater than old avg if Yes add it to max and increase the pointer else just increment the pointer
			if((double)(sum/k) >maxAvg) {
				maxAvg= (double)(sum)/k;
				left++;
			}
			else {
				left++;
			}
		}
		//return the max avg
		return maxAvg;

	}
	
	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(1) ----
	
	private double solution2(int[] b,int k) {

		int left=0;
		double maxAvg=Double.NEGATIVE_INFINITY;
		double sum = 0;
		 for (int i = 0; i < b.length; i++) {
		        sum += b[i];
		        if (i - left + 1 == k) {
		            if ((double) (sum / k) > maxAvg) {
		                maxAvg = (double) (sum / k);
		                sum -= b[left];
		                left++;
		            } else {
		                sum -= b[left];
		                left++;
		            }
		        }
		    }
		return maxAvg;

	}


}
