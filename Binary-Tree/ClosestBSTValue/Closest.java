public class Closest{
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

	public static int closestValue(TreeNode root, double target){
		if(root==null) return 0;
		int[] closest=new int[1];
		closest[0]=Integer.MAX_VALUE;
		preorderTraverse(root,target,Integer.MAX_VALUE,closest);
		return closest[0];
	}

	private static void preorderTraverse(TreeNode root, double target, double minDiff, int[] closest){
		if(root==null) return;
		//System.out.println(closest[0]);
		//System.out.println((double)(Math.abs(root.val-target))+","+diff);
		double diff=Math.abs(target-(double)root.val);
		System.out.println(diff-minDiff);
		if(diff>Integer.MAX_VALUE)
			closest[0]=Math.min(closest[0],root.val);
		else if(diff-minDiff<=0){
			minDiff=diff;
			closest[0]=root.val;
		}
		preorderTraverse(root.left,target,minDiff,closest);
		preorderTraverse(root.right,target,minDiff,closest);		
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);

		TreeNode.printBinaryTree(root,0);
		double target=4.1;
		System.out.println("Closest value to "+target+" is: "+closestValue(root,target));
	}
}