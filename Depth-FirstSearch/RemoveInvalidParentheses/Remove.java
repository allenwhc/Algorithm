import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Remove{
	public static List<String> removeInvalidParentheses(String s){
		int n=s.length();
		HashSet<String> set=new HashSet<String>();
		int left=0, right=0;
		for(int i=0; i<n; i++){
			char c=s.charAt(i);
			if(c=='(') ++left;
			else if(c==')'){
				if(left!=0) --left;
				else ++right;
			}
		}
		dfs(set,s,"",left,right,0,0);
		return new ArrayList<String>(set);
	}

	private static void dfs(HashSet<String> set, String s, String str, int left, int right, int idx, int pairs){
		if(idx==s.length()){
			if(left==0 && right==0 && pairs==0)
				set.add(str);
			return;
		}
		if(s.charAt(idx)!='(' && s.charAt(idx)!=')')
			dfs(set,s,str+s.charAt(idx),left,right,idx+1,pairs);
		else{
			if(s.charAt(idx)=='('){
				if(left>0)
					dfs(set,s,str,left-1,right,idx+1,pairs);
				dfs(set,s,str+s.charAt(idx),left,right,idx+1,pairs+1);
			}
			else if(s.charAt(idx)==')'){
				if(right>0)
					dfs(set,s,str,left,right-1,idx+1,pairs);
				if(pairs>0)
					dfs(set,s,str+s.charAt(idx),left,right,idx+1,pairs-1);
			}
		}
	}

	public static void main(String[] args) {
		String s="(a)())()";
		System.out.println("The invalid input string is: "+s);
		System.out.println("The corrected outputs are: "+Arrays.deepToString(removeInvalidParentheses(s).toArray()));
	}
}