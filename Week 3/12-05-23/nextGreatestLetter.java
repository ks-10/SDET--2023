package dailyProblems;

import org.junit.Test;

public class nextGreatestLetter {

	//@Test
	public void postiveScenario() {
		char[] b = { 'c','f','h'};
		char target = 'a';
		System.out.println(solution(b,target));
	}

	//@Test
	public void negativeScenario() {
		char[] b = { 'x','x','y','y'};
		char target = 'z';
		System.out.println(solution(b,target));
	}

	@Test
	public void EdgecaseScenario() {
		char[] b = { 'c','f','j'};
		char target = 'c';
		System.out.println(solution(b,target));
	}

	// Time complexcity ==> O(n)
	// Space complexcity ==> O(1)
	 public char solution(char[] letters, char target) {
		 //intialize the pointer to first position in the char array
		 int left=0;
		 //get the integer value of the target
		 int tar = (int) target;
		 //loop till the end of the array 
		 while(left<letters.length) {
			 //convert the current value in loop to integer
			 int currentV = (int)letters[left];
			 //check if the current valu is greater than target if yes return else increment the left pointer
			 if(currentV>tar) {
				return letters[left];
				}
			 left++;
		 }
		 //return the first value if the target is the greatest
	     return letters[0];   
	   }
		

}
