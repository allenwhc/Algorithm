import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class PalindromePartitioning{
	public static List<List<String>> partition(String s){
		List<List<String>> result=new ArrayList<List<String>>();
		if(s.length()==0) return result;
		helper(result,new ArrayList<String>(),s,0);
		return result;
	}

	private static void helper(List<List<String>> result, List<String> palindrome, String s, int idx){
		if(idx==s.length()){
			result.add(new ArrayList<String>(palindrome));
			return;
		}
		for(int i=idx; i<s.length(); i++){
			if(isPalindrome(s.toCharArray(),idx,i)){
				palindrome.add(s.substring(idx,i+1));
				helper(result,palindrome,s,i+1);
				palindrome.remove(palindrome.size()-1);
			}
		}

	}

	private static boolean isPalindrome(char[] c, int s, int e){
		if(s<0 || e>=c.length) return false;
		while(s<=e){
			if(c[s++]!=c[e--]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s="aab";
		for(List<String> list:partition(s))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}