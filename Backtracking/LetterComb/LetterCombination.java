import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class LetterCombination{
	private static String[] keys={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	public static List<String> letterCombinations(String digits){
		int n=digits.length();
		List<String> allCombs=new ArrayList<String>();
		if(n==0) return allCombs;
		getComb(allCombs,digits,new StringBuilder(),0);
		return allCombs;
	}

	private static void getComb(List<String> allCombs, String digits, StringBuilder str, int idx){
		if(idx==digits.length()){
			allCombs.add(str.toString());
			return;
		}
		for(int i=0; i<keys[digits.charAt(idx)-'0'].length(); i++){
			str.append(keys[digits.charAt(idx)-'0'].charAt(i));
			getComb(allCombs,digits,str,idx+1);
			str.deleteCharAt(str.length()-1);
		}
	}

	public static void main(String[] args) {
		String digits="23";
		System.out.println("All letter combinations of '"+digits+"' are: "+Arrays.deepToString(letterCombinations(digits).toArray()));
	}
}