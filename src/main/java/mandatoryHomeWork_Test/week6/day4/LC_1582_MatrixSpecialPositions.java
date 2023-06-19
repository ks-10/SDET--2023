package dailyProblems_Math;

import org.junit.Test;

public class MatrixSpecialPositions {
	
	@Test
	public void data() {
		int[][] a  = {{0,0},{0,0},{1,0}};
		System.out.println(diagonalSum(a));
	}

	//Time complexity is O(n^2)
	//Space complexity is O(1)
	public int diagonalSum(int[][] mat) {
		int sum=0;
		 boolean flag = false; boolean flag1 = false;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(mat[i][j]==1) {
					for (int j2 = 0; j2 < mat[i].length; j2++) {
						if(mat[i][j2]==1 && j!=j2) {
							flag1=false;
							break;
						}
						else {
							flag1=true;
						}
					}
					for (int k = 0; k < mat.length; k++) {
								if(mat[k][j]==1&& k!=i) {
									flag=false;
									break;
							}
								else {
									flag=true;
								}
						}
						
					}
				if(!flag==false && !flag1==false) {
					sum++;
					flag=false;
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
