package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class SortEvenandOddIndices {

	 @Test
	public void postiveScenario() {
		int[] b = {36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34 };
		//[9,46,15,45,15,41,27,34,32,31,33,31,36,26,36,16,44,6]
		System.out.println(Arrays.toString(solution2(b)));

	}

	// @Test
	public void negativeScenario() {
		int[] b = { 0, 1, 2 };
		System.out.println(Arrays.toString(solution2(b)));
	}

	//@Test
	public void EdgecaseScenario() {
		int[] b = { 0 };
		System.out.println(Arrays.toString(solution2(b)));
	}


	private int[] solution2(int[] b) {
		int left = 0;
		int even [] = new int[b.length];int odd [] = new int[b.length];
		
			while (left <= b.length-1) {
				if(left % 2 == 0) {
				even[left]=b[left];
				left++;
				//countE++;
				}
				else if(left % 2 == 1) {
				odd[left]=b[left];
				left++;
				//countO++;
				}
				
			}

			for (int i = 0; i < even.length; i++) {
		        for (int j = i + 1; j < even.length; j++) {
		            int tmp = 0;
		            if (even[i] > even[j] && even[i]!=0 && even[j]!=0) {
		                tmp = even[i];
		                even[i] = even[j];
		                even[j] = tmp;
		            }
		        }
		    }
			
			for (int i = 0; i < odd.length; i++) {
		        for (int j = i + 1; j < odd.length; j++) {
		            int tmp = 0;
		            if (odd[i] < odd[j] && odd[i]!=0 && odd[j]!=0) {
		                tmp = odd[i];
		                odd[i] = odd[j];
		                odd[j] = tmp;
		            }
		        }
		    }
				
			for (int i = 0; i < b.length; i++) {
				if(even[i]!=0) {
					b[i]= even[i];
				}
				else {
					b[i] = odd[i];
				}
			}
		return b;

	

}
}
