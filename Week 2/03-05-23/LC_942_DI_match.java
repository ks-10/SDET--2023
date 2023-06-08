package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class DI_match {

	@Test
	public void Scenario1() {
		String str= "IDID";
		System.out.println(Arrays.toString(solution(str)));

	}

	@Test
	public void Scenario2() {
		String str= "DDD";
		System.out.println(Arrays.toString(solution(str)));
	}

	@Test
	public void Scenario3() {
		String str= "III";
		System.out.println(Arrays.toString(solution(str)));
	}

	//--- Time complexcity ==> O(n) ---
	//--- Space complexcity ==> O(n) ----
	
	private int[] solution(String a) {
		//creating a int array for the output
		int []op = new int [a.length()+1];
		//intializing min value for I and max value for D
		int min=0; int max = a.length(); 
		//looping through the string to check for i and d
		for (int i = 0; i < a.length(); i++) {
			//if I is found assinging the min value to the array and incrementing the min value
			if(a.charAt(i)=='I') {
				op[i]=min;
				min++;
			}
			//if D is found assinging the max value to the array and decrementing the max value
			else if(a.charAt(i)=='D') {
				op[i]=max;
				max--;
			}
			
		}
		//remaining value in the min or max is assigned to the last value in op array
		op[op.length-1]=min;
		
		return op;
		
	}
}
