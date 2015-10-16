import java.util.Arrays;

public class WordSearch{
	public static boolean exist(char[][] board, String word){
		int m=board.length;
		int n=board[0].length;
		boolean flag=false;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++)
				if(isExist(board,word,i,j,0))
					flag=true;
		}
		return flag;
	}

	private static boolean isExist(char[][] board, String word, int row, int col, int idx){
		int m=board.length;
		int n=board[0].length;
		if(row<0 || col<0 || row>=m || col>=n) return false;
		if(board[row][col]==word.charAt(idx)){
			char temp=board[row][col];
			board[row][col]='#';
			if(idx==word.length()-1) return true;
			else if(isExist(board,word,row+1,col,idx+1) ||
					isExist(board,word,row-1,col,idx+1) ||
					isExist(board,word,row,col+1,idx+1) ||
					isExist(board,word,row,col-1,idx+1))
				return true;
			board[row][col]=temp;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board={{'A','B','C','E'},
  						{'S','F','C','S'},
  						{'A','D','E','E'}};
  		String word="ABCCED";
  		System.out.print("'"+word+"' ");
  		if(exist(board,word))
  			System.out.println("exists in: ");
  		else
  			System.out.println("doesn't exists in: ");
  		for(char[] b:board)
  			System.out.println(Arrays.toString(b));
	}
}