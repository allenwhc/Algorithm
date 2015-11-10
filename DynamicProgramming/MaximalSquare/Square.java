import java.util.Arrays;

public class Square{
	public static int maximalSquare(char[][] matrix){
		int m=matrix.length;
		if(m==0) return 0;
		int n=matrix[0].length;
		if(n==0) return 0;
		int[][] dp=new int[m][n];
		for(int i=0; i<m; i++)
			if(matrix[i][0]=='1') dp[i][0]=1;
		for(int j=0; j<n; j++)
			if(matrix[0][j]=='1') dp[0][j]=1;
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][j]=='1'){
					dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
				}
			}
		}
		int maxEdge=0;
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				maxEdge=Math.max(maxEdge,dp[i][j]);
		return maxEdge*maxEdge;
	}

	public static void main(String[] args) {
		char[][] matrix={{'1','0','1','0','0'},
						 {'1','0','1','1','1'},
						 {'1','1','1','1','1'},
						 {'1','0','0','1','0'}};
		System.out.println("The matrix is: ");
		for(char[] c:matrix)
			System.out.println(Arrays.toString(c));
		System.out.println("Area of maximal square is: "+maximalSquare(matrix));
	}
}