public class BalancedBinaryTree{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val=x; this.left=null; this.right=null;}
	}

	public static boolean isBalanced(TreeNode root){
		if(root==null) return true;
		int leftHeight=0, rightHeight=0;
		if(root.left!=null) leftHeight=height(root.left);
		if(root.right!=null) rightHeight=height(root.right);
		return (Math.abs(leftHeight-rightHeight)<=1) && isBalanced(root.left) && isBalanced(root.right);
	}

	private static int height(TreeNode root){
		if(root==null) return 0;
		return Math.max(height(root.left),height(root.right))+1;
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

		System.out.println(isBalanced(root));
	}
}