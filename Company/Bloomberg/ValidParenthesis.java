import java.util.Stack;

public class ValidParenthesis{
	public static boolean isValid(String s){
		if(s.length()==0) return true;
		Stack<Character> stack=new Stack<Character>();
		stack.push(s.charAt(0));

		for(int i=1; i<s.length(); i++){
			char c=s.charAt(i);
			if(stack.empty() || c=='(' || c=='[' || c=='{') stack.push(c);
			else if(c==')'){
				if(stack.pop()!='(') return false;	
			}
			else if(c==']'){
				if(stack.pop()!='[') return false;
			}
			else if(c=='}'){
				if(stack.pop()!='{') return false;
			}
			else return false;
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		String[] str={"([{}])","{}[]()","(([{()}]))","(([)])","()]"};
		for(String s:str){
			System.out.println(s+":"+isValid(s));
		}
	}
}