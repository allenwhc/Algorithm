import java.util.Arrays;

public class Islands{
	public static int numIslands(char[][] grid){
		int m=grid.length;
		int n=grid[0].length;
		int num=0;
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++){
				if(grid[i][j]=='1'){
					num++;
					bfs(grid,i,j);
				}
			}
		return num;
	}

	private static void bfs(char[][] grid, int i, int j){
		int m=grid.length;
		int n=grid[0].length;
		if(i<0 || i>=m || j<0 || j>=n) return;
		if(grid[i][j]=='1'){
			grid[i][j]='#';
			bfs(grid,i+1,j);
			bfs(grid,i-1,j);
			bfs(grid,i,j+1);
			bfs(grid,i,j-1);
		}
	}

	public static void main(String[] args) {
		char[][] grid={{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};
		System.out.println("# of islands: "+numIslands(grid));
	}
}