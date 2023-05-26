package dailyProblems_String;

import org.junit.Test;

public class BalancedStringSplit {
	@Test
	public void data() {
		String str = "RLRRRLLRLL";
		System.out.println(balancedStringSplit(str));
	}
	//@Test
	public void data1() {
		String str = "B0R0G0R9R0B0G0";
		System.out.println(balancedStringSplit(str));
	}
	//@Test
	public void data2() {
		String str = "G4";
		System.out.println(balancedStringSplit(str));

	}
	private int balancedStringSplit(String str) {
		int left=0;
		int right=0;
		int count =0;
		int count1 =0;
		int out=0;
		while(right<str.length()) {
			if(str.charAt(right)=='R') {
				 count++;
				
			}
			else if(str.charAt(right)=='L') {
				count1++;
				
			}
			if(count==count1) {
				out++;
				left=right;
				right++;
			}
			else {
				right++;
			}
		}
		return out;
	}
	 
}
