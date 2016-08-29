import java.util.Arrays;

public class Paths{
	public static int uniquePaths(int m, int n){
		if(m==0 || n==0) return 0;
		int[][] dp=new int[m][n];
		for(int i=0; i<m; i++)
			dp[i][0]=1;
		for(int j=0; j<n; j++)
			dp[0][j]=1;
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++)
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
		return dp[m-1][n-1];
	}

	public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
       	int m=obstacleGrid.length;
       	int n=obstacleGrid[0].length;
       	if(m==0 || n==0) return 0;
       	int[][] dp=new int[m][n];

       	for(int i=0; i<m; i++){
       		if(obstacleGrid[i][0]==0) dp[i][0]=1;
       		else break;
       	}
       	for(int j=0; j<n; j++){
       		if(obstacleGrid[0][j]==0) dp[0][j]=1;
       		else break;
       	}

       	for(int i=1; i<m; i++){
       		for(int j=1; j<n; j++){
       			if(obstacleGrid[i][j]==1) dp[i][j]=0;
       			else dp[i][j]=dp[i-1][j]+dp[i][j-1];
       		}
       	}

       	return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		int m=3;
		int n=7;
		System.out.println(uniquePaths(m,n)+" ways for "+m+"x"+n+" grid.");
		int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("For grid with obstacle as: ");
		for(int[] ii:obstacleGrid)
			System.out.println(Arrays.toString(ii));
		System.out.println(uniquePathsWithObstacles(obstacleGrid)+" ways.");
	}
}