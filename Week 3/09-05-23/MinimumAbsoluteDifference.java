package dailyProblems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MinimumAbsoluteDifference {

	 @Test
	public void postiveScenario() {
		int[] b = {3,8,-10,23,19,-4,-14,27};
		System.out.println((solution2(b)));

	}

	@Test
	public void negativeScenario() {
		int[] b = { 0, 1, 2 };
		System.out.println((solution2(b)));
	}

	@Test
	public void EdgecaseScenario() {
		int[] b = { 0 ,1};
		System.out.println((solution2(b)));
	}

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(n) ----
	private List<List<Integer>> solution2(int[] b) {
		//initializing a variable to check the minimum difference
		int min = Integer.MAX_VALUE;
		//Usin bubble sort to sort the given array in non decreasing order
		for (int i = 0; i < b.length; i++) {   	
			for (int j = i+1; j < b.length; j++) {
				if(b[i]>b[j]) {
					int temp = b[i];
					b[i] = b[j];
					b[j] =temp;
					
				}
			}
		}
		//checking for the minimum difference of the given sorted array 
		for (int i = b.length-1; i >0; i--) {
			if(b[i]-b[i-1]<min) {
				min = b[i]-b[i-1];
			}
		}
		//Creating a list to add the output 
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//checking if the given combination has the minimum diffence value == min
		for (int i = 0; i <b.length-1; i++) {
			if(min==b[i+1]-b[i]) {
				ArrayList<Integer> l = new ArrayList<>();
				l.add(b[i]);
				l.add(b[i+1]);
				list.add(l);
			//	System.out.println(b[i-1] +"," +b[i]);
			}
		}
		
		//returning the output as list
		return list;

	

}
}
