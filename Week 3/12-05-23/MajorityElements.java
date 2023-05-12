package dailyProblems;

import java.util.HashMap;

import org.junit.Test;

public class MajorityElements {

	@Test
	public void postiveScenario() {
		int[] b = {2,2,1,1,1,2,2};
		System.out.println(solution(b));
	}

	 @Test
	public void negativeScenario() {
		int[] b = {1};
		System.out.println(solution(b));
	}

	 //@Test
	public void EdgecaseScenario() {
		int[] b = {2,2,2,2,8,9,10,11,12};
		System.out.println(solution(b));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ----

	public int solution(int[] nums) {
		//Intializing hashmap to map the value and count of it
		HashMap<Integer,Integer> mp = new HashMap<>();
		//looping till the end of the array and adding it in map
		for (int i = 0; i <=nums.length-1; i++) {
			//If map contains the value check it is greater than input length/2 if yes return the value else add the value and count in map
			if(mp.containsKey(nums[i])) {
				mp.put(nums[i], mp.get(nums[i])+1);
				if(mp.get(nums[i])>(nums.length/2)) {
					return nums[i];
				}
			}
			else {
				mp.put(nums[i], 1);
			}
		}
//		int max=Integer.MIN_VALUE;
//		for (Entry<Integer, Integer> i : mp.entrySet()) {
//			if(i.getValue()>max) {
//				max=i.getValue();
//				if(max>(nums.length/2)) {
//					return i.getKey();
//				}
//			}
//		}
		//return if it has only one element in the array 
		return 1;
	}
	


}
