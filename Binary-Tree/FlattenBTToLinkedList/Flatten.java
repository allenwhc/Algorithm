import java.util.Stack;

public class Flatten{
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

	public static void flatten(TreeNode root){
		if(root==null) return;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode p=root;
		while(p!=null || !stack.empty()){
			if(p.right!=null) stack.push(p.right);
			if(p.left!=null){
				p.right=p.left;
				p.left=null;
			}
			else if(!stack.empty()){
				p.right=stack.pop();
			}
			p=p.right;
		}
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(6);

		System.out.println("The tree is: ");
		TreeNode.printBinaryTree(root,0);
		flatten(root);
		System.out.println("The flattened tree is: ");
		TreeNode.printBinaryTree(root,0);
	}
}