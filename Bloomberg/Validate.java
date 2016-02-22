public class Validate{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val=x;
			this.left=null;
			this.right=null;
		}
	}

	public static void printInorder(TreeNode root){
		if(root==null) return;
		printInorder(root.left);
		System.out.print(root.val+",");
		printInorder(root.right);
	}

	public static boolean isValidBST(TreeNode root){
		if(root==null) return true;
		int min_val=Integer.MIN_VALUE;
		int max_val=Integer.MAX_VALUE;
		return dfs(root,min_val,max_val);
	}

	private static boolean dfs(TreeNode root, int min_val, int max_val){
		if(root==null) return true;
		System.out.println(root.val+","+min_val+","+max_val);
		if((root.left!=null && root.val==Integer.MIN_VALUE) || (root.right!=null && root.val==Integer.MAX_VALUE)) return false;
		if(root.val<=min_val || root.val>=max_val) return false;
		return dfs(root.left,min_val,root.val) && dfs(root.right,root.val,max_val);
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(1);
		// root.right=new TreeNode(10);
		// root.left.right=new TreeNode(5);
		// root.right.left=new TreeNode(9);
		//TreeNode print=root;
		//printInorder(print);
		System.out.println(isValidBST(root));
	}
}