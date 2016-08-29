import java.util.Arrays;

public class Rectangle{
	public static int maximalRectangle(char[][] matrix){
		int m=matrix.length;
		if(m==0) return 0;
		int n=matrix[0].length;
		if(n==0) return 0;
		int[][] dp=new int[m][n];
		for(int i=0; i<m; i++)
			if(matrix[i][0]=='1')
				dp[i][0]=1;
		for(int i=0; i<m; i++)
			for(int j=1; j<n; j++){
				if(matrix[i][j]=='1')
					dp[i][j]=dp[i][j-1]+1;
			}

		int maxArea=0;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(dp[i][j]!=0){
					int k=i-1;
					int currMaxArea=dp[i][j];
					int len=dp[i][j];
					while(k>=0){
						if(dp[k][j]==0) break;
						else{
							len=Math.min(len,dp[k][j]);
							currMaxArea=Math.max(currMaxArea,len*(i-k+1));
							k--;
						}
					}
					maxArea=Math.max(maxArea,currMaxArea);
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		char[][] matrix={{'1','0','1','0','0'},
						 {'1','0','1','1','1'},
						 {'1','1','1','1','1'},
						 {'1','0','0','1','0'}};
		System.out.println("The matrix is: ");
		for(char[] c:matrix)
			System.out.println(Arrays.toString(c));
		System.out.println("Area of maximal square is: "+maximalRectangle(matrix));
	}
}