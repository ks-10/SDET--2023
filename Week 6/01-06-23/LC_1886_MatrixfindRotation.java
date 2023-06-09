package dailyProblems_Math;

import org.junit.Test;

public class MatrixfindRotation {
	
	@Test
	public void data() {
		int[][] a  = {{0,0,0},{0,1,0},{1,1,1}};
		int[][] b  = {{1,1,1},{0,1,0},{0,0,0}};
		System.out.println(findRotation(a,b));
	}

	public boolean findRotation(int[][] mat, int[][] target) {

		int n = mat.length;
        int c90 = 0, c180 = 0 , c270 = 0 , c0 = 0;

        for(int i = 0; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                
                if(target[i][j] == mat[n-1-j][i]) c90++;
                System.out.print(mat[n-1-i][n-1-j]);
                if(target[i][j] == mat[n-1-i][n-1-j]) c180++;
                if(target[i][j] == mat[j][n-1-i]) c270++;
                if(target[i][j] == mat[i][j]) c0++;
            }
        }

        if(c90==n*n || c180==n*n || c270==n*n || c0==n*n){
            return true;
        }
        else{
            return false;
        }
        
    }
}
