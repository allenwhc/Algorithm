import java.util.Stack;

public class Verify{
	public static boolean isValidSerialization(String preorder){
		String[] treeNodes=preorder.split(",");
		int depth=0;
		int i=0;
		while(i<treeNodes.length-1){
			if(treeNodes[i].equals("#")){
				if(depth==0) return false;
				else depth--;
			}
			else depth++;
			i++;
		}
		if(depth!=0) return false;
		return treeNodes[treeNodes.length-1].equals("#");
	}

	public static void main(String[] args) {
		String[] preorders={"9,3,4,#,#,1,#,#,2,#,6,#,#","1,#,#","9,#,#,1","#,#,#","#","9,#,93,#,9,9,#,#,#","2,#,#,6,9,9,#,7,#,#,#"};
		for(String preorder:preorders)
			System.out.println(preorder+"->"+isValidSerialization(preorder));
	}
}