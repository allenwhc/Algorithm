import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class VerticalOrder{
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

	public static class ShiftedTreeNode{
		TreeNode node;
		int shiftIdx;
		ShiftedTreeNode(TreeNode node, int idx){
			this.node=node;
			this.shiftIdx=idx;
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null) return result;
		TreeMap<Integer,List<Integer>> map=new TreeMap<Integer,List<Integer>>();
		dfs(root,map);
		for(Integer key:map.keySet())
			result.add(map.get(key));
		return result;
	}

	private static void dfs(TreeNode root, TreeMap<Integer,List<Integer>> map){
		if(root==null) return;
		Queue<ShiftedTreeNode> queue=new LinkedList<ShiftedTreeNode>();
		queue.offer(new ShiftedTreeNode(root,0));
		while(!queue.isEmpty()){
			ShiftedTreeNode curr=queue.poll();
			if(!map.containsKey(curr.shiftIdx))
				map.put(curr.shiftIdx,new ArrayList<Integer>(Arrays.asList(curr.node.val)));
			else
				map.get(curr.shiftIdx).add(curr.node.val);
			if(curr.node.left!=null) queue.offer(new ShiftedTreeNode(curr.node.left,curr.shiftIdx-1));
			if(curr.node.right!=null) queue.offer(new ShiftedTreeNode(curr.node.right,curr.shiftIdx+1));
		}
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(4);
		root.right.left=new TreeNode(2);
		root.right.right=new TreeNode(6);
		root.right.left.right=new TreeNode(3);
		root.right.right.left=new TreeNode(5);

		TreeNode.printBinaryTree(root,0);
		System.out.println("The vertical order of the above binary tree is: ");

		for(List<Integer> list:verticalOrder(root))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}