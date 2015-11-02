import java.util.Arrays;

public class Construct{
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

	public static TreeNode buildTree(int[] preorder, int[] inorder){
		int n=preorder.length;
		if(n==0) return null;
		return buildTreePreorderInorder(preorder,inorder,0,n-1,0);
	}

	private static TreeNode buildTreePreorderInorder(int[] preorder, int[] inorder, int start, int end, int idx){
		if(start>end) return null;
		TreeNode root=new TreeNode(preorder[idx]);
		if(start==end) return root;
		int i=start;
		for(;i<inorder.length; i++)
			if(inorder[i]==root.val) break;
		root.left=buildTreePreorderInorder(preorder,inorder,start,i-1,idx+1);
		root.right=buildTreePreorderInorder(preorder,inorder,i+1,end,idx+1+i-start);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder={4,2,1,3,6,5,7};
		int[] inorder={1,2,3,4,5,6,7};
		System.out.println("Tree constructed from preorder "+Arrays.toString(preorder)+" and inorder "+Arrays.toString(inorder)+" is: ");
		TreeNode.printBinaryTree(buildTree(preorder,inorder),0);
	}
}