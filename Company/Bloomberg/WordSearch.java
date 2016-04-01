import java.util.Arrays;

public class WordSearch{
	public static boolean exist(char[][] board, String word){
		int m=board.length;
		int n=board[0].length;
		if(m==0 || n==0) return false;
		boolean isExist=false;
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				if(helper(board,word.toCharArray(),i,j,0)) isExist=true;
		return isExist;
	}

	private static boolean helper(char[][] board, char[] word, int i, int j, int idx){
		int m=board.length;
		int n=board[0].length;
		if(i<0 || i>=m || j<0 || j>=n) return false;
		if(board[i][j]=='#') return false;
		if(board[i][j]==word[idx]){
			char temp=board[i][j];
			board[i][j]='#';
			if(idx==word.length-1) return true;
			else if(helper(board,word,i+1,j,idx+1) ||
					helper(board,word,i-1,j,idx+1) ||
					helper(board,word,i,j+1,idx+1) ||
					helper(board,word,i,j-1,idx+1))
				return true;			
			board[i][j]=temp;
		}
		return false;
	}

	 public static void main(String[] args) {
  		String[] word={"ABCCED","SEE","ABCB"};
  		for(String w:word){
  			char[][] board={{'A','B','C','E'},
  						{'S','F','C','S'},
  						{'A','D','E','E'}};
  			System.out.println(w+": "+exist(board,w));
  		}
	 }
}