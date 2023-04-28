package dailyProblems;

import org.junit.Test;

public class diamondPatternWithAlpha {

	// --- Time complexcity ==> O(n^2) ---
	// --- Space complexcity ==> O(1) ---

	@Test
	public void diamondPattern() {
		// Intializing the total alphabets in an array
		char[] alb = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char input = 'O';
		int len = 0;

		// calculating the length to print the pattern
		for (int i = 0; i < alb.length; i++) {
			len++;
			if (alb[i] == input) {
				break;
			}

		}

		// Printing the no of rows for the first half of the diamond
		for (int i = 0; i < len - 1; i++) {
			// printing the no of spaces before the pattern starts
			for (int j = 0; j < len - i; j++) {
				System.out.print(" ");
			}
			// printing the no of characters for the diamond
			for (int k = 0; k <= i; k++) {
				// printing the character only for first and last index in the current loop
				if (k == 0 || k == i) {
					System.out.print(alb[i] + " ");
				}
				// printing the spaces for rest of the indexes in the loop
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

		// Printing the no of rows for the second half of the diamond in reverse order
		for (int i = len - 1; i >= 0; i--) {
			// printing the no of spaces before the pattern starts
			for (int j = 0; j < len - i; j++) {
				System.out.print(" ");
			}
			// printing the no of characters for the diamond
			for (int k = 0; k <= i; k++) {
				// printing the character only for first and last index in the current loop
				if (k == 0 || k == i) {
					System.out.print(alb[i] + " ");
				}
				// printing the spaces for rest of the indexes in the loop
				else {
					System.out.print("  ");
				}
			}
			// exiting the current line
			System.out.println();
		}

	}

}
