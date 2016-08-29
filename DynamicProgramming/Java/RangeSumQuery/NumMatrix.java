import java.util.Arrays;

public class NumMatrix{
	private static int[][] dp;
	public NumMatrix(int[][] matrix){
		int m=matrix.length;
		if(m==0) return;
		int n=matrix[0].length;
		if(n==0) return;
		dp=new int[m][n];
		dp[0][0]=matrix[0][0];
		for(int i=1; i<m; i++)
			dp[i][0]=dp[i-1][0]+matrix[i][0];
		for(int j=1; j<n; j++)
			dp[0][j]=dp[0][j-1]+matrix[0][j];
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				dp[i][j]=dp[i-1][j]+dp[i][j-1]+matrix[i][j]-dp[i-1][j-1];
			}
		}
	}

	public static int sumRegion(int row1, int col1, int row2, int col2){
		int result=dp[row2][col2];
		if(row1>0) result-=dp[row1-1][col2];
		if(col1>0) result-=dp[row2][col1-1];
		if(row1>0 && col1>0) result+=dp[row1-1][col1-1];
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix={{3, 0, 1, 4, 2},
  						{5, 6, 3, 2, 1},
  						{1, 2, 0, 1, 5},
  						{4, 1, 0, 1, 7},
  						{1, 0, 3, 0, 5}};
		//int[][] matrix={{-1}};
  		NumMatrix numMatrix=new NumMatrix(matrix);
  		System.out.println(numMatrix.sumRegion(2,1,4,3));
  		System.out.println(numMatrix.sumRegion(1,1,2,2));
  		System.out.println(numMatrix.sumRegion(1,2,2,4));  		
	}
}