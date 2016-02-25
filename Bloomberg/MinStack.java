import java.util.Stack;

public class MinStack{
	private static Stack<Integer> minStack=new Stack<Integer>();
	private static Stack<Integer> actualStack=new Stack<Integer>();

	public static void push(int x){
		actualStack.push(x);
		if(x<=getMin()) minStack.push(x);
	}

	public static void pop(){
		if(actualStack.peek()==getMin()){
			actualStack.pop();
			minStack.pop();
		}else actualStack.pop();
	}

	public static int top(){
		return actualStack.peek();
	}

	public static int getMin(){
		if(minStack.empty()) return Integer.MAX_VALUE;
		else return minStack.peek();
	}

	public static void main(String[] args) {
		
	}
}