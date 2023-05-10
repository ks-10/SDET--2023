package dailyProblems;

import org.junit.Test;

public class searchInsertPosition {

		@Test
		public void data() {
			int a[] = { 1, 3, 5, 6 };
			int k = 3;
			System.out.println(solution(a,k));
		}

		//Time complexcity is O(log n))
		//space complexity is O(1)
		public int solution(int a[],int k) {
			//intializing two pointer to L=0 & R = length -1
			int left = 0;
			int right = a.length - 1;
			//looping untill left==right
			while (left <= right) {
				//calculating the mid value for the array to divide the problem
				int mid = (left + right) / 2;
				//If mid is less than the target increment the left
				if (a[mid] < k) {
					left = mid + 1;
				} 
				//If mid is greater than the target decrement the right
				else if (a[mid] > k) {
					right = mid - 1;
				} else
					//else return mid value 
					return mid;
			}
			//return left for the target to be inserted 
			return left;

		}
	}

