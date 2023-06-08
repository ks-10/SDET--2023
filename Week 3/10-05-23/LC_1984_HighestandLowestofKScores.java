package dailyProblems;

import java.util.Arrays;

import org.junit.Test;

public class HighestandLowestofKScores {

	@Test
	public void postiveScenario() {
		int[] b = { 41900, 69441, 94407, 37498, 20299, 10856, 36221, 2231, 54526, 79072, 84309, 76765, 92282, 13401,
				44698, 17586, 98455, 47895, 98889, 65298, 32271, 23801, 83153, 12186, 7453, 79460, 67209, 54576, 87785,
				47738, 40750, 31265, 77990, 93502, 50364, 75098, 11712, 80013, 24193, 35209, 56300, 85735, 3590, 24858,
				6780, 50086, 87549, 7413, 90444, 12284, 44970, 39274, 81201, 43353, 75808, 14508, 17389, 10313, 90055,
				43102, 18659, 20802, 70315, 48843, 12273, 78876, 36638, 17051, 20478 };
		int k = 5;
		System.out.println((solution2(b, k)));
	}

	@Test
	public void negativeScenario() {
		int[] b = { 90 };
		int k = 1;
		System.out.println((solution2(b, k)));
	}

	// @Test
	public void EdgecaseScenario() {
		int[] b = { 0, 1 };
		int k = 1;
		System.out.println((solution2(b, k)));
	}
	
	//Time complexity O(n log n)
	//Space complexity O(n)

	private int solution2(int[] b, int k) {
		//Intializing the minimum value
		int op = Integer.MAX_VALUE;
		//returning 0 if we have only one element
		if (b.length == 1) {
			return 0;
		}
		//Sorting the array to find the min difference
		Arrays.sort(b);
		//Sorting using bubble sort
//		for (int i = 0; i < b.length; i++) {
//			for (int j = i + 1; j < b.length; j++) {
//				if (b[i] > b[j]) {
//					int temp = b[i];
//					b[i] = b[j];
//					b[j] = temp;
//				}
//			}
//		}
		
		//Initialzing j till K element and i to start of the loop
		int j = k - 1;
		int i = 0;
		//looping to find the minimum differnce in the array 
		while (j <= b.length - 1) {
			if (b[j] - b[i] < op) {
				op = b[j++] - b[i++];
			} else {
				i++;
				j++;
			}

		}

		return op;
	}

}
