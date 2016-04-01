import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BTLevelOrder{
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val=x;this.left=null;this.right=null;}
	}

	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> level=new ArrayList<List<Integer>>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		if(root==null) return level;
		
		queue.add(root);

		while(queue.size()>0){
			List<Integer> list=new ArrayList<Integer>();
			int size=queue.size();
			for(int i=0; i<size; i++){
				TreeNode n=queue.poll();
				list.add(n.val);
				if(n.left!=null) queue.add(n.left);
				if(n.right!=null) queue.add(n.right);
			}
			level.add(list);
		}
		return level;
	}



	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(4);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(6);
		root.left.right=new TreeNode(5);
		root.right.right=new TreeNode(3);
		root.left.right.right=new TreeNode(1);
		root.right.right.left=new TreeNode(2);
		root.left.right.right.left=new TreeNode(2);

		for(List<Integer> list:levelOrder(root))
			System.out.println(Arrays.deepToString(list.toArray()));
		
	}
}