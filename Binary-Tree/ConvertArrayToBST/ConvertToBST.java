
public class ConvertToBST{
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

	public static TreeNode sortedArrayToBST(int[] nums){
		int n=nums.length;
		if(n==0) return null;
		return dfs(nums,0,n,null);
	}

	private static TreeNode dfs(int[] nums, int start, int end, TreeNode root){
		if(start>=end) return root;
		int middle=(end-start)/2+start;
		root=new TreeNode(nums[middle]);
		root.left=dfs(nums,start,middle,root.left);
		root.right=dfs(nums,middle+1,end,root.right);
		return root;
	}

	public static void main(String[] args) {
		int[] nums={1,2,3,4,5,6,7};
		TreeNode.printBinaryTree(sortedArrayToBST(nums),0);
	}
}