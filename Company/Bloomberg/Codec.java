import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Codec{
	public static  class TreeNode{
		int val;
		TreeNode left,right;
		TreeNode(int x){val=x;}
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

	public static String serialize(TreeNode root){
		if(root==null) return "[]";
		StringBuilder result=new StringBuilder();
		result.append("[");
		Queue<TreeNode> curr=new LinkedList<TreeNode>();
		curr.offer(root);
		boolean done=false;

		while(!done && curr.size()>0){
			int size=curr.size();
			Queue<TreeNode> next=new LinkedList<TreeNode>();
			done=true;
			while(curr.size()>0){
				TreeNode node=curr.poll();
				if(node==null){
					result.append("null").append(",");
					continue;
				}
				result.append(String.valueOf(node.val)).append(",");
				if(node.left!=null || node.right!=null) done=false;
				next.offer(node.left);
				next.offer(node.right);
			}
			curr=next;
		}
		result.deleteCharAt(result.length()-1);
		result.append("]");
		return result.toString();
	}

	public static TreeNode deserialize(String data){
		if(data.equals("[]")) return null;
		StringBuilder str=new StringBuilder(data);
		str.deleteCharAt(0); str.deleteCharAt(str.length()-1);

		String[] levelOrder=str.toString().split(",");
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		TreeNode root=new TreeNode(Integer.parseInt(levelOrder[0]));
		queue.offer(root);

		TreeNode parent=null;
		boolean left=true;

		for(int i=1; i<levelOrder.length; i++){
			TreeNode child=null;
			if(!levelOrder[i].equals("null")){
				child=new TreeNode(Integer.parseInt(levelOrder[i]));
				queue.offer(child);
			}
			if(left){
				parent=queue.poll();
				parent.left=child;
				left=false;
			}else{
				parent.right=child;
				left=true;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		String data="[1,2,3,null,null,4,5]";
		System.out.println(data);
		TreeNode root=deserialize(data);
		TreeNode.printBinaryTree(root,0);
		System.out.println(serialize(root));

	}
}