import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class TreePaths{
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

	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<String>();
        if(root==null) return result;
        dfs(result,"",root);
        return result;
    }

    private static void dfs(List<String> allPaths, String path, TreeNode root){
    	if(root==null)
    		return;
    	if(root.left==null && root.right==null){
    	    allPaths.add(path+root.val);
    	    return;
    	}
    	dfs(allPaths,path+root.val+"->",root.left);
    	dfs(allPaths,path+root.val+"->",root.right);
    }

    public static void main(String[] args) {
    	TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		//root.left.left=new TreeNode(5);
		root.left.right=new TreeNode(6);
		root.right.left=new TreeNode(6);
		// root.right.right=new TreeNode(8);
		// root.left.right.left=new TreeNode(7);
		// root.left.right.right=new TreeNode(4);
		System.out.println("The tree is: ");
		TreeNode.printBinaryTree(root,0);

		System.out.println(Arrays.deepToString(binaryTreePaths(root).toArray()));
    }
}