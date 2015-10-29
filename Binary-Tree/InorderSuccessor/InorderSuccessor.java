public class InorderSuccessor{
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

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		if(root==null || (root.left==null && root.right==null)) return null;
		TreeNode successor=null;
		//If right subtree of p is not null, find the leftmost node in right subtree
		if(p.right!=null){
			TreeNode curr=p.right;
			while(curr!=null){
				successor=curr;
				curr=curr.left;
			}
		}
		//Else, traverse tree from root
		else{
			TreeNode curr=root;
			while(curr!=null && curr.val!=p.val){
				if(curr.val<p.val)
					curr=curr.right;
				else{
					successor=curr;
					curr=curr.left;
				}
			}
		}
		return successor;
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

    	TreeNode p=root.left.right.right;
    	System.out.print("The inorder successor of "+p.val+" is: ");
    	if(inorderSuccessor(root,p)!=null)
    		System.out.println(inorderSuccessor(root,p).val);
    	else
    		System.out.println("null");
	}
}