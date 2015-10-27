import java.util.Stack;

public class KthSmallest{
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

	public static int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode curr=root;
        boolean isDone=false;
        int kth=0;
        int i=0;
        while(!isDone && i<k){
        	if(curr!=null){
        		stack.push(curr);
        		curr=curr.left;
        	}
        	else{
        		if(!stack.empty()){
        			curr=stack.pop();
        			kth=curr.val;
        			i++;
        			curr=curr.right;
        		}
        		else isDone=true;
        	}
        }
        return kth;
    }

    private static void inorderTraverse(TreeNode node, int k, int step, int[] element){
    	if(node==null || step==k) {
    		element[0]=node.val;
    		return;}
    	inorderTraverse(node.left,k,step+1,element);
    	inorderTraverse(node.right,k,step+1,element);
    }

    public static void main(String[] args) {
    	TreeNode root=new TreeNode(7);
    	root.left=new TreeNode(3);
    	root.right=new TreeNode(11);
    	root.left.left=new TreeNode(1);
    	root.left.right=new TreeNode(5);
    	root.right.left=new TreeNode(9);
    	root.right.right=new TreeNode(13);

    	System.out.println("The BST is: ");
    	TreeNode.printBinaryTree(root,0);
    	int k=5;
    	System.out.println("The "+k+"th smallest element in BST is: "+kthSmallest(root,k));
    }
}