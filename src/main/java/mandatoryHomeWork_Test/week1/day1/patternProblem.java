package dailyProblems;
import org.junit.Test;

public class patternProblem {
	
	@Test
	public void data() {
		int a = 7;
		solution(a);

	}
	private void solution(int a) {
		for (int i = 1; i <= a; i++) { // this will be the row 
			for (int j = 1; j <= a-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
				System.out.print(" ");
			}
		System.out.println();
		}
    }
		
}

