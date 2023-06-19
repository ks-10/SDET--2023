package dailyProblems;

import org.junit.Test;

public class sandglassProblem {

	@Test
	public void sandglass() {
		int a = 5;
		
		for (int i = a; i >= 1; i--) {
			for (int j = 0; j < a-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <=i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < a; i++) {
			for (int j = 1; j < a-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <=i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	
		
		
		
	}
	
	
}
