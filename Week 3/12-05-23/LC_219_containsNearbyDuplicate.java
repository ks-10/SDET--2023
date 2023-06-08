
package dailyProblems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class containsNearbyDuplicate {

	@Test
	public void postiveScenario() {
		int[] b = {1,2,3,1};
		int k=3;
		System.out.println(solution(b,k));
	}

	 //@Test
	public void negativeScenario() {
		int[] b = {6,8,6,8,0,4,1,2,9,9};
		int k=2;
		System.out.println(solution(b,k));
	}

	 //@Test
	public void EdgecaseScenario() {
		int[] b = {1,12,-5,-6,50,3};
		int k=4;
	}

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(1) ----
	public boolean solution(int[] nums, int k) {
		//looping to check i and i+1 is equal && (i-j)<=k if yes return true
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]==nums[j] && Math.abs(i-j)<=k) {
					return true;
				}
			}
		}
		return false;
	}
	
	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----
	public boolean solution2(int[] nums, int k) {
		//Initalizing the map to store tha value and count
		Map<Integer,Integer> mp = new HashMap<>();
		//looping to add the values in the map
		for (int i = 0; i < nums.length; i++) {
			//checking if the value is already present and checking the count is less than or equal to K 
			//If yes return true else add the value in map
			if(mp.containsKey(nums[i])) {
				if(i-mp.get(nums[i])<=k) {
					return true;
				}
			}
			mp.put(nums[i], i);
			}
		
		return false;
	}


}
