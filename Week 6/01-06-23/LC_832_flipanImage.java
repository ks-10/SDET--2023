package dailyProblems_Math;

public class flipanImage {

	 public int[][] flipAndInvertImage(int[][] a) {
	        for (int i = 0; i < a.length; i++) {
				int left = 0;
				int right = a[i].length - 1;

				while (left <= right) {
					System.out.println(a[i][left] + " ," + a[i][right]);
					if (left == right) {
						if (a[i][left] == 0) {
							a[i][left] = 1;
						} else {
							a[i][left] = 0;
						}
						left++;
					} else {
						int temp = a[i][left];
						a[i][left] = a[i][right];
						a[i][right] = temp;

						if (a[i][left] == 0) {
							a[i][left] = 0 + 1;
						} else {
							a[i][left] = 0;
						}
						if (a[i][right] == 0) {
							a[i][right] = 0 + 1;
						} else {
							a[i][right] = 0;
						}

						System.out.println(a[i][left] + " ," + a[i][right]);
						left++;
						right--;
					}
				}

			}

	        return a;
	    }

}
