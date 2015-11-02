import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Sum{
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

	public static int sumNumbers(TreeNode root){
		if(root==null) return 0;
		List<Integer> nums=new ArrayList<Integer>();
		int sum=0;
		getNumber(root,nums,0);
		System.out.println(Arrays.deepToString(nums.toArray()));
		for(int i:nums)
			sum+=i;
		return sum;
	}

	private static void getNumber(TreeNode node, List<Integer> nums, int value){
		if(node==null) return;
		if(node.left==null && node.right==null){
			value=value*10+node.val;
			nums.add(value);
			//return;
		}
		//value=value*10+node.val;
		getNumber(node.left,nums,value*10+node.val);
		getNumber(node.right,nums,value*10+node.val);
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(7);
		TreeNode.printBinaryTree(root,0);
		System.out.println("Sum root-to-leaf is: "+sumNumbers(root));
	}
}