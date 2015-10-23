import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;

public class CloneGraph{
	public static class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){label=x;neighbors=new ArrayList<UndirectedGraphNode>();}
	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node==null) return null;
		HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();


		//1.Clone the node itself
		UndirectedGraphNode cloneNode=new UndirectedGraphNode(node.label);
		map.put(node,cloneNode);	//Initialize hash map
		queue.offer(node);	//Initialize queue

		//2.BFS all neighbors of node
		while(queue.size()>0){
			UndirectedGraphNode curr=queue.poll();
			List<UndirectedGraphNode> currNodeNeighbors=curr.neighbors;
			for(UndirectedGraphNode neighbors:currNodeNeighbors){
				if(!map.containsKey(neighbors)){
					UndirectedGraphNode cloneNeighbors=new UndirectedGraphNode(neighbors.label);
					queue.offer(neighbors);
					map.put(neighbors,cloneNeighbors);
					map.get(curr).neighbors.add(cloneNeighbors);
				}
				else
					map.get(curr).neighbors.add(map.get(neighbors));
			}
		}
		return cloneNode;
	}

	public static void main(String[] args) {
		UndirectedGraphNode node1=new UndirectedGraphNode(0);
		UndirectedGraphNode node2=new UndirectedGraphNode(1);
		UndirectedGraphNode node3=new UndirectedGraphNode(2);
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		node3.neighbors.add(node3);

		UndirectedGraphNode cloneNode1=cloneGraph(node1);
		System.out.println("Node: "+node1.label);
		System.out.print("Neighbors: ");
		for(int i=0; i<cloneNode1.neighbors.size(); i++)
			System.out.print(cloneNode1.neighbors.get(i).label+",");
		System.out.println();

		UndirectedGraphNode cloneNode2=cloneGraph(node2);
		System.out.println("Node: "+node2.label);
		System.out.print("Neighbors: ");
		for(int i=0; i<cloneNode2.neighbors.size(); i++)
			System.out.print(cloneNode2.neighbors.get(i).label+",");
		System.out.println();

		UndirectedGraphNode cloneNode3=cloneGraph(node3);
		System.out.println("Node: "+node3.label);
		System.out.print("Neighbors: ");
		for(int i=0; i<cloneNode3.neighbors.size(); i++)
			System.out.print(cloneNode3.neighbors.get(i).label+",");
		System.out.println();
	}
}