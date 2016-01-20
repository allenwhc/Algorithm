import java.util.Arrays;

public class Longest{
	//private static int[] directions={0,-1,0,1,0};
	public static int longestIncreasingPath(int[][] matrix){
		int m=matrix.length;
		if(m==0) return 0;
		int n=matrix[0].length;
		if(n==0) return 0;

		int longest=0;
		int[][] dp=new int[m][n];
		boolean[][] visited=new boolean[m][n];

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				int curr_length=dfs(matrix,dp,visited,i,j);
				longest=Math.max(longest,curr_length);
			}
		}
		return longest;
	}

	private static int dfs(int[][] matrix, int[][] dp, boolean[][] visited, int i, int j){	
		int m=matrix.length;
		int n=matrix[0].length;
		if(!visited[i][j]){
			int[] directions={0,-1,0,1,0};
			visited[i][j]=true;
			int current_max=0;
			for(int d=0; d<4; d++){
				int next_row=i+directions[d];
				int next_col=j+directions[d+1];
				if(next_row>=0 && next_row<m &&
					next_col>=0 && next_col<n &&
					matrix[i][j]<matrix[next_row][next_col]){
					int curr=dfs(matrix,dp,visited,next_row,next_col);
					current_max=Math.max(current_max,curr);
				}
			}
			dp[i][j]=current_max+1;
		}
		return dp[i][j];
	}

	public static void main(String[] args) {
		int[][] matrix={{3,4,5},{3,2,6},{2,2,1}};
		System.out.println("Longest increasing path length: "+longestIncreasingPath(matrix));
	}
}