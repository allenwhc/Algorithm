import java.util.Arrays;

public class SudokuSolver{
	public static void solveSudoku(char[][] board){
		if(board.length==0) return;
		solve(board);
	}

	private static boolean solve(char[][] board){
		int n=board.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]=='.'){
					for(char num='1'; num<='9'; num++){
						if(isValidNumber(board,i,j,num)){
							board[i][j]=num;
							if(solve(board)) return true;
							else board[i][j]='.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValidNumber(char[][] board, int row, int col, char num){
		//Check col-th column
		for(int i=0; i<board.length; i++){
			if(board[i][col]==num) return false;
		}

		//Check row-th row
		for(int j=0; j<board.length; j++)
			if(board[row][j]==num) return false;

		//Check 3x3 sqaure
		for(int i=row/3*3; i<row/3*3+3; i++){
			for(int j=col/3*3; j<col/3*3+3; j++)
				if(board[i][j]==num) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board={{'.','.','2','4','9','.','.','6','.'},
						{'9','.','.','.','.','.','.','.','.'},
						{'.','5','3','.','.','7','.','.','.'},
						{'.','.','.','.','.','.','.','7','6'},
						{'3','.','.','6','.','1','.','.','9'},
						{'5','4','.','.','.','.','.','.','.'},
						{'.','.','.','9','.','.','7','5','.'},
						{'.','.','.','.','.','.','.','.','3'},
						{'.','1','.','.','2','3','4','.','.'}};
		System.out.println("The Sudoku board is: ");
		for(char[] b:board)
			System.out.println(Arrays.toString(b));
		solveSudoku(board);
		System.out.println("After solving, the Sudoku board is: ");
		for(char[] b:board)
			System.out.println(Arrays.toString(b));
	}

}