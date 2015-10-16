import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class GenerateParanthese{
	public static List<String> generateParenthesis(int n){
		List<String> allParenthesis=new ArrayList<String>();
		if(n==0) return  allParenthesis;
		generate(allParenthesis,new StringBuilder(),n,0,0,0);
		return allParenthesis;
	}

	private static void generate(List<String> allParenthesis, StringBuilder str, int n, int step, int left, int right){
		if(step==2*n){
			allParenthesis.add(str.toString());
			return;
		}
		if(left<n){
			str.append('(');
			generate(allParenthesis,str,n,step+1,left+1,right);
			str.deleteCharAt(str.length()-1);
		}
		if(right<left){
			str.append(')');
			generate(allParenthesis,str,n,step+1,left,right+1);
			str.deleteCharAt(str.length()-1);
		}
	}
	
	public static void main(String[] args) {
		int n=3;
		System.out.println(n+" pairs of parenthesis are: "+Arrays.deepToString(generateParenthesis(n).toArray()));
	}
}