import java.util.List;
import java.util.ArrayList;

public class CloneGraph{
	public static class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){label=x;neighbors=new ArrayList<UndirectedGraphNode>();}
	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){

	}

	public static void main(String[] args) {
		UndirectedGraphNode node1=new UndirectedGraphNode(0);
		UndirectedGraphNode node2=new UndirectedGraphNode(1);
		UndirectedGraphNode node3=new UndirectedGraphNode(2);
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node3);
		node3.neighbors.add(node3);
	}
}