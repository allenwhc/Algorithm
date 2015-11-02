public class Recover{
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

	private static TreeNode n1=null;
	private static TreeNode n2=null;
	private static TreeNode prev=null;

	public static void recoverTree(TreeNode root){
		inorderTraverse(root);
		//if(n1!=null && n2!=null){
		int temp=n1.val;
		n1.val=n2.val;
		n2.val=temp;
		//}
	}

	private static void inorderTraverse(TreeNode root){
		if(root==null) return;
		inorderTraverse(root.left);
		if(prev!=null){
		    if(prev.val>=root.val){
			    if(n1==null) n1=prev;
			    n2=root;
		    }
		}
		prev=root;
		inorderTraverse(root.right);
 	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
		//root.left=new TreeNode(2);
		root.right=new TreeNode(1);
		// root.left.left=new TreeNode(6);
		// root.left.right=new TreeNode(3);
		// root.right.left=new TreeNode(5);
		// root.right.right=new TreeNode(7);

		System.out.println("The misplaced BST is: ");
		TreeNode.printBinaryTree(root,0);
		recoverTree(root);
		System.out.println("The corrected BST is: ");
		TreeNode.printBinaryTree(root,0);
	}
}