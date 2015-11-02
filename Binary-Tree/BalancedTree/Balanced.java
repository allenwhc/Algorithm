public class Balanced{
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

	public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right))
        	return true;
        return false;
    }

    private static int height(TreeNode node){
    	if(node==null) return 0;
    	return Math.max(height(node.left),height(node.right))+1;
    }

    public static void main(String[] args) {
    	TreeNode root=new TreeNode(1);
    	root.left=new TreeNode(2);
    	root.right=new TreeNode(3);
    	root.left.left=new TreeNode(4);
    	root.left.right=new TreeNode(5);
    	root.left.left.left=new TreeNode(6);

    	TreeNode.printBinaryTree(root,0);
    	if(isBalanced(root))
    		System.out.println("The tree is balanced.");
    	else
    		System.out.println("The tree is not balanced.");
    }
}