package dailyProblems;

import org.junit.Test;

// time complexity ==> O(n^2)
// space complexity ==> O(1)
public class diamondPattern {

	@Test
	public void diamondPattern() {
		int a = 5;
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <=i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for (int i = a; i >= 0; i--) {
			for (int j = 0; j < a-i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <=i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
}
