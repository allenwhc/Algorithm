import java.util.Stack;
import java.util.HashMap;

public class LongestConsecutive{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val=x;
			this.left=null;
			this.right=null;
		}

		public static TreeNode newNode(int val){
			TreeNode node=new TreeNode(val);
			node.left=null;
			node.right=null;
			return node;
		}
		
		public static void printBinaryTree(TreeNode root, int level){
		    if(root==null)
		         return;
		    printBinaryTree(root.right, level+1);
		    if(level!=0){
		        for(int i=0;i<level-1;i++)
		            System.out.print("|\t");
		            System.out.println("|-------"+root.val);
		    }
		    else
		        System.out.println(root.val);
		    printBinaryTree(root.left, level+1);
		}  
	}

	public static class NodeLength{
		int length;
		TreeNode node;
		NodeLength(TreeNode n, int l){node=n;length=l;}
	}

	public static int longestConsecutive(TreeNode root){
		if(root==null) return 0;
		int[] maxLength=new int[1];
		dfs(root,0,maxLength,root.val);
		return maxLength[0];
	}

	private static void dfs(TreeNode node, int length, int[] currMaxLength, int target){
		if(node==null) return;
		if(node.val==target) length++;
		else length=1;
		currMaxLength[0]=Math.max(currMaxLength[0],length);
		dfs(node.left,length,currMaxLength,node.val+1);
		dfs(node.right,length,currMaxLength,node.val+1);
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(2);
		root.right.right=new TreeNode(4);
		root.right.right.right=new TreeNode(5);

		System.out.println("The tree is: ");
		TreeNode.printBinaryTree(root,0);
		System.out.println("Length of the longest consecutive sequence is: "+longestConsecutive(root));
	}
}