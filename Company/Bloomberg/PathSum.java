import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PathSum{
	public static class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int x){val=x;left=null;right=null;}
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

	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root==null) return result;
		List<Integer> path=new ArrayList<Integer>();
		path.add(root.val);
		dfs(root,result,path,sum-root.val);
		return result;
	}

	private static void dfs(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum){
		if(root==null) return;
		if(sum==0 && root.left==null && root.right==null){
			result.add(new ArrayList<Integer>(path));
			//return;
		}
		if(root.left!=null){
			path.add(root.left.val);
			dfs(root.left,result,path,sum-root.left.val);
			path.remove(path.size()-1);
		}
		if(root.right!=null){
			path.add(root.right.val);
			dfs(root.right,result,path,sum-root.right.val);
			path.remove(path.size()-1);
		}
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(2);
		root.right.right.left=new TreeNode(5);
		root.right.right.right=new TreeNode(1);
		TreeNode.printBinaryTree(root,0);
		int sum=22;
		List<List<Integer>> result=pathSum(root,sum);
		for(int i=0; i<result.size(); i++){
			System.out.print((i+1)+":");
			for(int j=0; j<result.get(i).size(); j++)
				System.out.print(result.get(i).get(j)+" ");
			System.out.println();
		}
	}
}