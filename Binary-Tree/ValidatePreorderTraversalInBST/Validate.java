import java.util.Arrays;
import java.util.Stack;

public class Validate{
	public static boolean verifyPreorder(int[] preorder){
		Stack<Integer> stack=new Stack<Integer>();
		if(preorder.length==0) return true;
		int prev=Integer.MIN_VALUE;
		for(int i=0; i<preorder.length; i++){
			if(prev>Integer.MIN_VALUE&& preorder[i]<prev)
				return false;
			while(!stack.empty() && preorder[i]>stack.peek())
				prev=stack.pop();
			stack.push(preorder[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] preorder={7,3,1,9,5,11,13};
		if(verifyPreorder(preorder))
			System.out.println(Arrays.toString(preorder)+" is a correct preorder traversal of a BST");
		else
			System.out.println(Arrays.toString(preorder)+" is not a correct preorder traversal of a BST");

	}
}