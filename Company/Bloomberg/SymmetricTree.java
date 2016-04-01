public class SymmetricTree{
	public static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int x){val=x;left=right=null;}

		public static void printBinaryTree(TreeNode root, int level){
		    if(root==null)
		         return;
		    printBinaryTree(root.right, level+1);
		    if(level!=0){
		        for(int i=0;i<level-1;i++)
		            System.out.print("|\t");
		        	System.out.println("|-------"+root.val);
		    }
		    else{
		    	//if(root.next==null)
		            System.out.println(root.val);
		        //else
		        //	System.out.println("|-------"+root.val+","+root.next.val);
		        }
		    printBinaryTree(root.left, level+1);
		} 
	}

	public static boolean isSymmetric(TreeNode root){
		if(root==null) return true;
		return dfs(root.left,root.right);
	}

	private static boolean dfs(TreeNode p, TreeNode q){
		if(p==null) return q==null;
		if(q==null) return p==null;
		if(p.val!=q.val) return false;
		return dfs(p.left,q.right) && dfs(p.right,q.left);
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.right=new TreeNode(3);
		//root.left.right=new TreeNode(4);
		//root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(3);
		TreeNode.printBinaryTree(root,0);
		System.out.println(isSymmetric(root));
	}
}