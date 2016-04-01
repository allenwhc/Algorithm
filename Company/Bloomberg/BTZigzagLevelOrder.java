import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BTZigzagLevelOrder{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val=x;this.left=null;this.right=null;}
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null) return result;
		Stack<TreeNode> s_left=new Stack<TreeNode>();
		Stack<TreeNode> s_right=new Stack<TreeNode>();

		boolean leftToRight=true;
		s_left.push(root);
		
		while(!s_left.empty() || !s_right.empty()){
			List<Integer> l=new ArrayList<Integer>();
			TreeNode node=null;
			if(leftToRight){
				while(!s_left.empty()){
					node=s_left.pop();
					l.add(node.val);
					if(node.left!=null) s_right.push(node.left);
					if(node.right!=null) s_right.push(node.right);
				}
			}else{
				while(!s_right.empty()){
					node=s_right.pop();
					l.add(node.val);
					if(node.right!=null) s_left.push(node.right);
					if(node.left!=null) s_left.push(node.left);
				}
			}
			result.add(l);
			leftToRight=!leftToRight;
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(4);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(6);
		root.left.right=new TreeNode(5);
		root.right.right=new TreeNode(3);
		root.left.right.right=new TreeNode(1);
		root.right.right.left=new TreeNode(2);
		root.left.right.right.left=new TreeNode(2);

		for(List<Integer> list:zigzagLevelOrder(root))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}