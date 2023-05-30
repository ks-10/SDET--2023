package dailyProblems_Math;

import org.junit.Test;

public class minimumCommonValue {

	@Test
	public void data() {
		int []a  = {1,2,3};
		int []b = {1,3};
		System.out.println(getCommon(a,b));
	}
	
	@Test
	public void data1() {
		int []a  = {1,2,3};
		int []b = {4,5,6};
		System.out.println(getCommon(a,b));
	}
	
	@Test
	public void data2() {
		int []a  = {};
		int []b = {};
		System.out.println(getCommon(a,b));
	}
	//Time complexity is O(n)
	//Space complexity is O(1)
	public int getCommon(int[] nums1, int[] nums2) {
        int left=0;
        int right=0;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]>nums2[right]){
                right++;
            }
            else if(nums2[right]>nums1[left]){
                left++;
            }
            else{
                return nums1[left];
            }
        }

        return -1;
}
	
}
