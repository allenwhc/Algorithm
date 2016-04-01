public class KthSmallestBST{

	public static class TreeNode{
		int val;
		TreeNode left,right;
		int leftSize;
		TreeNode(int x){val=x;leftSize=1;left=null;right=null;}

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

	private static TreeNode root=null;

	public static int kthSmallest(TreeNode root, int k){
		if(root==null || k<1) return -1;
		TreeNode p=root;
		while(p!=null){
			if(p.leftSize==k) return p.val;
			else if(k>p.leftSize){
				k-=p.leftSize;
				p=p.right;
			}
			else p=p.left;
		}
		return 0;
	}

	public static void insert(int val){
		root=construct(root,val);
	}

	private static TreeNode construct(TreeNode node, int val){
		if(node==null) return new TreeNode(val);

		if(val<node.val) {node.left=construct(node.left,val);node.leftSize++;}
		else if(val>node.val) node.right=construct(node.right,val);
		return node;
	}

	public static void main(String[] args) {
		insert(8);
		insert(5);
		insert(3);
		insert(4);
		insert(6);
		insert(13);
		insert(9);
		insert(15);

		TreeNode.printBinaryTree(root,0);
		int k=6;
		System.out.println(k+"th smallest node in BST is: "+kthSmallest(root,k));
	}

}