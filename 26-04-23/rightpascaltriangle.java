package dailyProblems;

import org.junit.Test;

public class rightpascaltriangle {

//TIme complexcity is O(n^2)
//Space complexity is O(1)	
	
	@Test
	public void rigthpascalTriangle() {
		int a = 5;
		
		for (int i = 0; i <= a-1; i++) {
			for (int k = 0; k <=i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i = a-2; i >= 0; i--) {
			for (int k = 0; k <=i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
}
