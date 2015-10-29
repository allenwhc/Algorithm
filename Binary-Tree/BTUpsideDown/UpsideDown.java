import java.util.Stack;

public class UpsideDown{
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

	public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        TreeNode q=root;
        TreeNode p=q.left;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(q.right);
        q.right=null;
        //1.Right rotate BT by 90 degree
        while(q.left!=null){
        	p=q.left;
        	q.left=(stack.empty())?q.right:stack.pop();
        	stack.push(p.right);
        	p.right=q;
        	q=p;
        }

        //2.Reconnect
        p=q;
        while(p!=null){
        	if(p.right!=null){
        		p.left=p.right.left;
        		p.right.left=null;
        	}
        	p=p.right;
        }
        return q;
    }

    public static void main(String[] args) {
    	TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		//root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		//root.left.right=new TreeNode(5);
		//root.left.left.left=new TreeNode(6);
		//root.left.left.right=new TreeNode(7);
		System.out.println("Original: ");
		TreeNode.printBinaryTree(root,0);
		TreeNode upsideDown=upsideDownBinaryTree(root);
		System.out.println("Upside-down: ");
		TreeNode.printBinaryTree(upsideDown,0);
    }
}