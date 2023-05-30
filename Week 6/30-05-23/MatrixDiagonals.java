package dailyProblems_Math;

import org.junit.Test;

public class MatrixDiagonals {
	
	@Test
	public void data() {
		int[][] a  = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(diagonalSum1(a));
	}

	//Time complexity is O(n^2)
	//Space complexity is O(1)
	public int diagonalSum(int[][] mat) {
		int sum=0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(i==j) {
					sum += mat[i][j];
				}
				else if (i + j == mat.length - 1) {
		            sum += mat[i][j];
		        }
			}
		}
		return sum;
        
    }
	//Time complexity is O(n)
	//Space complexity is O(1)
	public int diagonalSum1(int[][] mat) {
		int sum=0;
		for (int i = 0; i < mat.length; i++) {
					sum += mat[i][i];
				if (i  != mat.length -i- 1) {
		            sum += mat[i][ mat.length -i- 1];
		        }
			
		}
		return sum;
        
    }
}
