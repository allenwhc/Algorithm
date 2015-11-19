import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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

	private static int[][] directions={{0,1},	//right neighbor
										{1,0},	//bottom neighbor
										{0,-1},	//left neighbor
										{-1,0}};	//top neighbor
	public static List<Integer> numIslands2(int m, int n, int[][] positions){
		List<Integer> result=new ArrayList<Integer>();
		if(m<=0 || n<=0 || positions.length==0) return result; 

		int[] roots=new int[m*n];
		Arrays.fill(roots,-1);

		int count=0;
		int k=positions.length;
		for(int i=0; i<k; i++){
			int root=positions[i][0]*n+positions[i][1];
			roots[root]=root;	//Initialize the root mapped to itself
			count++;

			//Try out each direction
			for(int j=0; j<directions.length; j++){
				int x=positions[i][0]+directions[j][0];
				int y=positions[i][1]+directions[j][1];
				int posOfNbr=x*n+y; 	//Map the position of each neighor into 1D array
				if(x<0 || x>=m || y<0 || y>=n || roots[posOfNbr]==-1) continue;	//If out of bound or corresponding root doesn't exist, continue

				int idNbr=findIslands(roots,posOfNbr);
				if(root!=idNbr){
					roots[idNbr]=root;
					count--;
				}
			}
			//System.out.println(Arrays.toString(roots));
			result.add(count);
		}
		return result;
	}

	private static int findIslands(int[] roots, int root){
		while(root!=roots[root]) root=roots[root];
		return root;
	}

	public static void main(String[] args) {
		char[][] grid={{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};
		System.out.println("# of islands: "+numIslands(grid));

		int m=3;
		int n=3;
		int[][] positions={{0,0},{0,1},{1,2},{2,1}};
		List<Integer> num=numIslands2(m,n,positions);
		System.out.println("The trend of # of islands is: "+Arrays.deepToString(num.toArray()));
	}
}