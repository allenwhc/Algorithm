import java.util.LinkedList;

public class BSTIterator{
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

	private static LinkedList<TreeNode> stack;
	public BSTIterator(TreeNode root) {
        stack=new LinkedList<TreeNode>();
        TreeNode p=root;
        while(p!=null){
        	stack.push(p);
        	p=p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public static boolean hasNext() {
        return !(stack.size()==0);
    }

    /** @return the next smallest number */
    public static int next() {
        if(!hasNext()) return 0;
        TreeNode node=stack.pop();
        int nodeValue=node.val;
        node=node.right;
        while(node!=null){
        	stack.push(node);
        	node=node.left;
        }
        return nodeValue;
    }

    public static void main(String[] args) {
    	TreeNode root=new TreeNode(20);
    	root.left=new TreeNode(8);
    	root.right=new TreeNode(22);
    	root.left.left=new TreeNode(4);
    	root.left.right=new TreeNode(12);
    	root.left.right.left=new TreeNode(10);
    	root.left.right.right=new TreeNode(14);

    	System.out.println("The BST is: ");
    	TreeNode.printBinaryTree(root,0);

    	BSTIterator it=new BSTIterator(root);
    	while(it.hasNext())
    		System.out.println("Next smallest number is: "+it.next());
    }
}