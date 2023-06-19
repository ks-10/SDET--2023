package dailyProblems;

import org.junit.Test;

public class maximum69 {

	@Test
	public void postiveScenario() {
		int b = 9696;
		System.out.println(solution(b));

	}

	@Test
	public void negativeScenario() {
		int b = 699996;
		System.out.println(solution(b));
	}

	@Test
	public void EdgecaseScenario() {
		int b = 6; 
		System.out.println(solution(b));
	}

	// Time complexcity ==> O(n)
	// Space complexcity ==> O(n)
	private int solution(int b) {
		//converting the int to character array
		char[] ch = Integer.toString(b).toCharArray();

		//looping through the input
		for (int i = 0; i < ch.length; i++) {
			//checking for the charcter to be 9 or not, If NO->replacing the char with 9 and breaking the loop
			if (ch[i] != '9') {
				ch[i] = '9';
				break;
			}
		}
		//converting the ch to int again and returning the output
		int output = Integer.parseInt(new String(ch));
		return output;

	}

}
