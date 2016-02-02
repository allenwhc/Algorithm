
public class CountUniValue{
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

	public static int countUnivalSubtrees(TreeNode root){
		if(root==null) return 0;
		int[] count=new int[1];
		dfs(root,count);
		return count[0];
	}

	private static boolean dfs(TreeNode root, int[] count){
		if(root==null) return true;
		if(root.left==null && root.right==null){
			count[0]++;
			return true;
		}

		boolean left=dfs(root.left,count);
		boolean right=dfs(root.right,count);

		if(left && right && 
		   (root.left==null || root.left.val==root.val) && 
		   (root.right==null || root.right.val==root.val)){
			count[0]++;
			return true;
		}
		return false;
	} 

	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(1);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(5);
		root.left.right=new TreeNode(5);
		root.right.right=new TreeNode(5);
		System.out.println("Binary Tree: ");
		TreeNode.printBinaryTree(root,0);
		System.out.println("# of univalue subtree: "+countUnivalSubtrees(root));
	}
}