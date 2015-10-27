import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Zigzag{
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

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> zigzag=new ArrayList<List<Integer>>();
		if(root==null) return zigzag;
		boolean isLeftToRight=true;
		int h=height(root);
		for(int i=0; i<h; i++){
			List<Integer> traverse=new ArrayList<Integer>();
			levelOrderTraversal(root,i,isLeftToRight,traverse);
			zigzag.add(traverse);
			isLeftToRight=!isLeftToRight;
		}
		return zigzag;
	}

	private static void levelOrderTraversal(TreeNode node, int level, boolean isLeftToRight, List<Integer> traverse){
		if(node==null) return;
		if(level==0){
			traverse.add(node.val);
		}
		else{
			if(isLeftToRight){
				levelOrderTraversal(node.left,level-1,isLeftToRight,traverse);
				levelOrderTraversal(node.right,level-1,isLeftToRight,traverse);
			}
			else{
				levelOrderTraversal(node.right,level-1,isLeftToRight,traverse);
				levelOrderTraversal(node.left,level-1,isLeftToRight,traverse);
			}
		}
	}

	private static int height(TreeNode root){
		if(root==null) return 0;
		return Math.max(height(root.left),height(root.right))+1;
	}
 
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.left=new TreeNode(5);
		root.left.left.right=new TreeNode(6);
		System.out.println("The binary tree is: ");
		TreeNode.printBinaryTree(root,0);
		List<List<Integer>> zigzag=zigzagLevelOrder(root);
		System.out.println("Zigzag level-order traversal is: ");
		for(List<Integer> list:zigzag)
			System.out.println(Arrays.deepToString(list.toArray()));
	}

}