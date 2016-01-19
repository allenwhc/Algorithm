
public class CountRangeSum{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		int left_size;
		int duplicate;

		TreeNode(int x){
			this.val=x;
			this.left_size=0;
			this.duplicate=1;
			this.left=null;
			this.right=null;
		}

		public static TreeNode newNode(int val){
			TreeNode node=new TreeNode(val);
			node.left=null;
			node.right=null;
			return node;
		}

	}

	public static int countRangeSum(int[] nums, int lower, int upper) {
        TreeNode root=null;
        int sum=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
        	sum+=nums[i];
        	count+=getBound(root,sum-lower,true)-getBound(root,sum-upper,false);
        	root=insert(root,sum);
        }
        return count;
    }

    private static TreeNode insert(TreeNode root, int val){
    	if(root==null) root=new TreeNode(val);
    	else if(val==root.val) root.duplicate++;
    	else if(val<root.val){
    		root.left_size++;
    		root.left=insert(root.left,val);
    	}
    	else
    		root.right=insert(root.right,val);
    	return root;
    }

    private static int getBound(TreeNode root, int val, boolean isItself){
    	if(root==null) return 0;
    	else if(val==root.val) return root.left_size+(int)(isItself?root.duplicate:0);
    	else if(val<root.val) return getBound(root.left,val,isItself);
    	else return getBound(root.right,val,isItself)+root.left_size+root.duplicate;
    }

    public static void main(String[] args) {
    	int[] nums={-2,5,-1};
    	int lower=-2;
    	int upper=2;
    	System.out.println(countRangeSum(nums,lower,upper));
    }
}