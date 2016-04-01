public class ConstructBSTPreIn{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val=x;}

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
		if(preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length) return null;
		return build(preorder,inorder,0,0,preorder.length-1);
	}

	private static TreeNode build(int[] preorder, int[] inorder, int idx, int s, int e){
		if(s>e) return null;
		TreeNode root=new TreeNode(preorder[idx]);
		int i=0;
		for(; i<inorder.length; i++)
			if(inorder[i]==preorder[idx]) break;
		root.left=build(preorder,inorder,idx+1,s,i-1);
		root.right=build(preorder,inorder,idx+i+1-s,i+1,e);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder={7,3,1,5,11,9,13};
		int[] inorder={1,3,5,7,9,11,13};

		TreeNode.printBinaryTree(buildTree(preorder,inorder),0);
	}
}