
public class RangeSum{
	public static class TreeNode{
		long val;
		int duplicate;	//count duplicate element
		int leftSize;	//count # of nodes in left subtree
		int rightSize;	//count # of nodes in right subtree
		TreeNode left,right;

		TreeNode(long x){
			this.val=x;
			this.duplicate=1;
			this.leftSize=0;
			this.rightSize=0;
			this.left=null;
			this.right=null;
		}

		public static TreeNode newNode(long x){
			TreeNode node=new TreeNode(x);
			node.left=null;
			node.right=null;
			return node;
		}
	}

	public static int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length;
        if(n==0) return 0;
        long[] sums=new long[n+1];
        for(int i=0; i<n; i++) sums[i+1]=sums[i]+nums[i];

        TreeNode root=new TreeNode(sums[0]);
    	int count=0;
    	for(int i=1; i<sums.length; i++){
    		count+=getCount(root,sums[i]-upper,sums[i]-lower);
    		insert(root,sums[i]);
    	}
        return count;
    }

    private static int getCount(TreeNode root, long lower, long upper){
    	int totalCount=root.duplicate+root.leftSize+root.rightSize;
    	return totalCount-countSmallerSum(root,lower)-countGreaterSum(root,upper);
    }

    private static int countSmallerSum(TreeNode root, long val){
    	if(root==null) return 0;
    	else if(root.val==val) return root.leftSize;
    	else if(root.val>val) return countSmallerSum(root.left,val);
    	else return countSmallerSum(root.right,val)+root.duplicate+root.leftSize;
    }

    private static int countGreaterSum(TreeNode root, long val){
    	if(root==null) return 0;
    	else if(root.val==val) return root.rightSize;
    	else if(root.val<val) return countGreaterSum(root.right,val);
    	else return countGreaterSum(root.left,val)+root.duplicate+root.rightSize;
    }

    private static TreeNode insert(TreeNode root, long val){
    	if(root==null) root=new TreeNode(val);
    	else if(root.val==val) root.duplicate++;
    	else if(root.val>val){
    		root.leftSize++;
    		root.left=insert(root.left,val);
    	}
    	else{
    		root.rightSize++;
    		root.right=insert(root.right,val);
    	}
    	return root;
    }
    
    public static void main(String[] args) {
    	int[] nums={2147483647,-2147483648,-1,0};
    	int lower=-1;
    	int upper=0;

    	System.out.println("# of sum: "+countRangeSum(nums,lower,upper));
    }
}