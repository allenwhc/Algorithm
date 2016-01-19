import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CountSmaller{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		int left_size;
		int duplicate;

		TreeNode(int x, int size){
			this.val=x;
			this.left_size=size;
			this.duplicate=1;
			this.left=null;
			this.right=null;
		}

		public static TreeNode newNode(int val, int size){
			TreeNode node=new TreeNode(val,size);
			node.left=null;
			node.right=null;
			return node;
		}

	}

	public static List<Integer> countSmaller(int[] nums){
		List<Integer> counts=new ArrayList<Integer>();
		int n=nums.length;
		if(n==0) return counts;
		TreeNode root=null;
		for(int i=0; i<n; i++) counts.add(0);
		for(int i=n-1; i>=0; i--)
			root=insert(root,counts,nums[i],i,0);
		return counts;
	}

	private static TreeNode insert(TreeNode root, List<Integer> counts, int val, int idx, int leftNodeSum){
		if(root==null){
			root=new TreeNode(val,0);
			counts.set(idx,leftNodeSum);
		}
		else if(val==root.val){
			root.duplicate++;	//duplicate node
			counts.set(idx,leftNodeSum+root.left_size);
		}
		else if(val<root.val){
			root.left_size++;
			root.left=insert(root.left,counts,val,idx,leftNodeSum);
		}
		else
			root.right=insert(root.right,counts,val,idx,leftNodeSum+root.duplicate+root.left_size);
		return root;
	}

	public static void main(String[] args) {
		int[] nums={12, 1, 2, 3, 0, 11, 4};
		System.out.println(Arrays.deepToString(countSmaller(nums).toArray()));
	}
}