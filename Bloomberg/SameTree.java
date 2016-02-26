
public class SameTree{
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

	public static boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null) return q==null;
		if(q==null) return p==null;
		if(p.val!=q.val) return false;
		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}

	public static void main(String[] args) {
		TreeNode p=new TreeNode(1);
		p.left=new TreeNode(2);
		p.right=new TreeNode(3);
		p.left.right=new TreeNode(4);
		p.right.left=new TreeNode(5);

		TreeNode q=new TreeNode(1);
		q.left=new TreeNode(2);
		q.right=new TreeNode(3);
		q.left.right=new TreeNode(4);
		q.right.right=new TreeNode(5);

		System.out.println("Tree 1: ");
		TreeNode.printBinaryTree(p,0);
		System.out.println("Tree 2: ");
		TreeNode.printBinaryTree(q,0);

		System.out.println(isSameTree(p,q));
	}
}