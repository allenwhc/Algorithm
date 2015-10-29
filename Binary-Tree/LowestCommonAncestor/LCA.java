public class LCA{
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

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root==null) return null;
		if(p==root || q==root) return root;
		TreeNode leftLCA=lowestCommonAncestor(root.left,p,q);
		TreeNode rightLCA=lowestCommonAncestor(root.right,p,q);
		if(leftLCA!=null && rightLCA!=null) return root;
		else return (leftLCA!=null)?leftLCA:rightLCA;
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(5);
		root.right=new TreeNode(1);
		root.left.left=new TreeNode(6);
		root.left.right=new TreeNode(2);
		root.right.left=new TreeNode(0);
		root.right.right=new TreeNode(8);
		root.left.right.left=new TreeNode(7);
		root.left.right.right=new TreeNode(4);
		System.out.println("The tree is: ");
		TreeNode.printBinaryTree(root,0);

		TreeNode p=root.left.left;
		TreeNode q=root.left.right.right;
		System.out.println("LCA of "+p.val+" and "+q.val+" is: "+lowestCommonAncestor(root,p,q).val);

	}
}