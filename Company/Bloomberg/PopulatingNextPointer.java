import java.util.Queue;
import java.util.LinkedList;

public class PopulatingNextPointer{
	public static class TreeLinkNode{
		int val;
		TreeLinkNode left,right,next;
		TreeLinkNode(int x){val=x;left=right=next=null;}
		public static void printBinaryTree(TreeLinkNode root, int level){
		    if(root==null)
		         return;
		    printBinaryTree(root.right, level+1);
		    if(level!=0){
		        for(int i=0;i<level-1;i++)
		            System.out.print("|\t");
		        	System.out.print("|-------"+root.val);
		        if(root.next==null)
		            System.out.println(", null");
		        else
		        	System.out.println(", "+root.next.val);
		    }
		    else{
		    	//if(root.next==null)
		            System.out.println(root.val+","+"null");
		        //else
		        //	System.out.println("|-------"+root.val+","+root.next.val);
		        }
		    printBinaryTree(root.left, level+1);
		} 
	}
	private static TreeLinkNode root=null;
	public static void connect(TreeLinkNode root){
		if(root==null) return;
		Queue<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
		q.offer(root);

		while(q.size()>0){
			TreeLinkNode node=q.poll();
			int size=q.size();
			if(node.left!=null) q.offer(node.left);
			if(node.right!=null) q.offer(node.right);
			for(int i=0; i<size; i++){
				TreeLinkNode nextNode=q.poll();
				node.next=nextNode;
				node=node.next;
				if(node.left!=null) q.offer(node.left);
				if(node.right!=null) q.offer(node.right);
			}
			node.next=null;
		}
	}

	public static void insert(int val){
		root=construct(root,val);
	}

	private static TreeLinkNode construct(TreeLinkNode node, int val){
		if(node==null) return new TreeLinkNode(val);
		if(val<node.val) node.left=construct(node.left,val);
		else if(val>node.val) node.right=construct(node.right,val);
		return node;
	}

	public static void main(String[] args) {
		insert(10);
		insert(5);
		insert(3);
		insert(12);
		insert(15);
		insert(4);
		insert(7);
		connect(root);
		TreeLinkNode.printBinaryTree(root,0);
	}
}