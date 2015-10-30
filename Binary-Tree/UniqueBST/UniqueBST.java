import java.util.List;
import java.util.ArrayList;

public class UniqueBST{
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

	public static int numTrees(int n){
		if(n<=1) return 1;
		int[] dp=new int[n];
		for(int i=0; i<n;i++) 
			dp[i]=-1;
		return solver(n,dp);
	}

	private static int solver(int n, int[] dp){
		if(n<0) return 0;
		else if(n==1 || n==0) return 1;
		else{
			int sum=0;
			for(int i=0; i<n; i++){
				if(dp[i]==-1)
					dp[i]=solver(i,dp);
				if(dp[n-i-1]==-1)
					dp[n-i-1]=solver(n-i-1,dp);
				sum+=dp[i]*dp[n-i-1];
			}
			return sum;
		}
	}

	public static List<TreeNode> generateTrees(int n){
		return createTrees(1,n);
	}

	private static List<TreeNode> createTrees(int start, int end){
		List<TreeNode> roots=new ArrayList<TreeNode>();
		if(start>end){
			roots.add(null);
			return roots;
		}

		for(int i=start; i<=end; i++){
			List<TreeNode> lefts=createTrees(start,i-1);
			List<TreeNode> rights=createTrees(i+1,end);
			for(TreeNode left:lefts){
				for(TreeNode right:rights){
					TreeNode root=new TreeNode(i);
					root.left=left;
					root.right=right;
					roots.add(root);
				}
			}
		}
		return roots;
	}

	public static void main(String[] args) {
		int n=3;
		System.out.println("There are "+numTrees(n)+" unique BSTs for "+n+" nodes.");
		System.out.println("All unique BSTs are: ");
		for(TreeNode root:generateTrees(n))
			TreeNode.printBinaryTree(root,0);
	}
}