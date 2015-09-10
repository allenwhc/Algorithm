import java.util.ArrayList;
import java.util.List;

public class Solution {
	//Undirected graph
	public static boolean undirectedGraphCycle(int n, int[][] edges){
		List<List<Integer>> adjacentList=new ArrayList<List<Integer>>();
		for(int i=0; i<n; i++)
			adjacentList.add(new ArrayList<>());
		for(int i=0; i<edges.length; i++){
			int u=edges[i][0];
			int v=edges[i][1];
			adjacentList.get(u).add(v);
			adjacentList.get(v).add(u);
		}
		boolean[] visited=new boolean[n];
		if(hasCycle(adjacentList, visited, 0, -1))
			return true;
		return false;
	}
	
	private static boolean hasCycle(List<List<Integer>> adjacentList, boolean[] visited, int u, int parent){
		visited[u]=true;
		for(int i=0; i<adjacentList.get(u).size(); i++){
			int v=adjacentList.get(u).get(i);
			if((visited[v] && parent!=v) || (!visited[v] && hasCycle(adjacentList, visited, v, u)))
				return true;
		}
		return false;
	}

	//Directed Graph
	public static boolean directedGraphCycle(int n, int[][] edges){
		List<List<Integer>> adjacentList=new ArrayList<List<Integer>>();
		for(int i=0; i<n; i++)
			adjacentList.add(new ArrayList<>());
		for(int i=0; i<edges.length; i++)
			adjacentList.get(edges[i][0]).add(edges[i][1]);
		if(detectCycle(adjacentList, n))
			return true;
		return false;
	}
	
	private static boolean detectCycle(List<List<Integer>> adjacentList, int n){
		boolean[] visited=new boolean[n];
		boolean[] stack=new boolean[n];
		for(int i=0; i<n; i++){
			if(findCycle(adjacentList, i, stack, visited))
				return true;
		}
		return false;
	}
	
	private static boolean findCycle(List<List<Integer>> adjacentList, int v, boolean[] stack, boolean[] visited){
		if(!visited[v]){
			visited[v]=stack[v]=true;
			for(Integer i:adjacentList.get(v)){
				if(!visited[i] && findCycle(adjacentList, i, stack, visited))
					return true;
				else if(stack[i])
					return true;
			}
		}
		stack[v]=false;
		return false;
	}
	
	public static void main(String[] args) {
		int n=6;
		int[][] undirectedEdges={{0,1},{0,2},{2,3},{2,5},{3,4},{4,5}};
		System.out.println("There are "+n+" vertices in graph.");
		System.out.println("Undirected graph:");
		for(int i=0; i<undirectedEdges.length; i++)
			System.out.println("Vertex "+(undirectedEdges[i][0]+1)+" connects to vertex: "+(undirectedEdges[i][1]+1));
		if(undirectedGraphCycle(n, undirectedEdges))
			System.out.println("The undirected graph contains cycle.");
		else 
			System.out.println("The undirected graph doesn't contain cycle.");
		
		System.out.println();
		System.out.println("Directed Graph");
		int[][] directedEdges={{0,1},{1,2},{1,5},{2,3},{3,4}};
		for(int i=0; i<directedEdges.length; i++)
			System.out.println("Vertex "+(directedEdges[i][0]+1)+" goes to vertex: "+(directedEdges[i][1]+1));
		if(directedGraphCycle(n, directedEdges))
			System.out.println("The directed graph contains cycle.");
		else 
			System.out.println("The directed graph doesn't contain cycle.");
	}
}
