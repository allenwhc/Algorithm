import java.lang.StringBuilder;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Codec{
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

	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	if(root==null) return "";
    	List<TreeNode> currLevelNodeList=new ArrayList<TreeNode>();
    	List<String> levelOrder=new ArrayList<String>();
    	currLevelNodeList.add(root);
    	while(!currLevelNodeList.isEmpty()){
    		String str=new String();
    		List<TreeNode> nextLevelNodeList=new ArrayList<TreeNode>();
    		for(TreeNode node:currLevelNodeList){
    			if(node==null){
    				levelOrder.add("null");
    				continue;
    			}
    			levelOrder.add(Integer.toString(node.val));
    			nextLevelNodeList.add(node.left);
    			nextLevelNodeList.add(node.right);
    		}
    		currLevelNodeList=nextLevelNodeList;
    	}
    	for(int i=levelOrder.size()-1; i>=0; i--){
    		if(levelOrder.get(i).equals("null"))
    			levelOrder.remove(i);
    		else break;
    	}
    	StringBuilder result=new StringBuilder();
    	result.append("[");
    	for(int i=0; i<levelOrder.size(); i++){
    		result.append(levelOrder.get(i));
    		if(i!=levelOrder.size()-1) result.append(",");
    	}
    	result.append("]");
        return result.toString();    
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data=="") return null;
    	StringBuilder str=new StringBuilder(data);
    	str.deleteCharAt(0);
    	str.deleteCharAt(str.length()-1);
    	data=new String(str.toString());
    	List<String> parsedInput=Arrays.asList(data.split(","));
    	int n=parsedInput.size();
    	TreeNode root=new TreeNode(Integer.valueOf(parsedInput.get(0)));
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);	//Add root to tail of queue
    	boolean isLeft=true;
    	TreeNode curr=null;

    	for(int i=1; i<n; i++){
    		TreeNode node=null;
    		String s=parsedInput.get(i);

    		if(!s.equals("null")){
    			node=new TreeNode(Integer.valueOf(s));
    			queue.offer(node);
    		}
			if(isLeft){
				curr=queue.poll();
				isLeft=false;
				curr.left=node;
			}
			else{
				curr.right=node;
				isLeft=true;
			}
    	}
        return root;
    }

    public static void main(String[] args) {
    	TreeNode root=new TreeNode(1);
    	root.left=new TreeNode(2);
    	root.left.left=new TreeNode(3);
    	root.left.left.left=new TreeNode(4);
    	root.left.left.left.left=new TreeNode(5);

    	System.out.println("The input binary tree is: ");
    	TreeNode.printBinaryTree(root,0);
    	System.out.println("The serialized output is: "+serialize(root));
    	String serializedInput="[1,2,null,3,null,4,null,5]";
    	System.out.println("Serialized input is: "+serializedInput);
    	System.out.println("Deserialized binary tree is:");
    	TreeNode.printBinaryTree(deserialize(serializedInput),0);
    }
}