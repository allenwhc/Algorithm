import java.util.Arrays;

public class WallsAndGates{
	public static void wallsAndGates(int[][] rooms){
		int m=rooms.length;
		int n=rooms[0].length;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(rooms[i][j]==0){
					solve(rooms,i+1,j,rooms[i][j]+1);	//Reach to next row
					solve(rooms,i-1,j,rooms[i][j]+1);	//Reach to previous row
					solve(rooms,i,j+1,rooms[i][j]+1);	//Reach to next column
					solve(rooms,i,j-1,rooms[i][j]+1);	//Reach to previous column
				}
			}
		}
	}

	private static void solve(int[][] rooms, int row, int col, int count){
		int m=rooms.length;
		int n=rooms[0].length;
		if(row<0 || col<0 || row>=m || col>=n) return;
		if(rooms[row][col]==-1) return;
		if(rooms[row][col]>count)
			rooms[row][col]=count;
		else return;

		solve(rooms,row+1,col,count+1);
		solve(rooms,row-1,col,count+1);
		solve(rooms,row,col+1,count+1);
		solve(rooms,row,col-1,count+1);
	}

	public static void main(String[] args) {
		int inf=Integer.MAX_VALUE;
		int[][] rooms={{inf,-1,0,inf,inf,-1},
						{inf,inf,inf,-1,inf,0},
						{inf,-1,inf,-1,inf,-1},
						{0,-1,inf,inf,-1,inf}};
		System.out.println("The original floor plan is: ");
		for(int[] r:rooms)
			System.out.println(Arrays.toString(r));
		wallsAndGates(rooms);
		System.out.println("The updated floor plan is: ");
		for(int[] r:rooms)
			System.out.println(Arrays.toString(r));
	}
}