import java.util.Stack;
import java.util.Arrays;
import java.lang.StringBuilder;

public class RemoveDuplicateLetters{
	public static String removeDuplicateLetters(String s){
		if(s.length()==0 || s==null) return "";
		int[] occurrence=new int[26];	//count # of occurrences of each letter
		boolean[] visited=new boolean[26];	//mark if visited of each letter
		char[] ch=s.toCharArray();
		for(char c:ch)
			occurrence[c-'a']++;
		//System.out.println(Arrays.toString(occurrence));
		int idx=0;
		Stack<Character> stack=new Stack<Character>();

		for(char c:ch){
			idx=c-'a';
			occurrence[idx]--;
			if(!visited[idx]){	//if current letter hasn't appeared yet
				while(!stack.isEmpty() && c<stack.peek() && occurrence[stack.peek()-'a']!=0){
					char oldTop=stack.pop();
					visited[oldTop-'a']=false;
				}
				stack.push(c);
				visited[idx]=true;
			}
		}

		StringBuilder res=new StringBuilder();
		while(!stack.isEmpty())
			res.append(stack.pop());
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		String s="cbacdcbc";
		System.out.println("'"+s+"' -> '"+removeDuplicateLetters(s)+"'.");
	}
}