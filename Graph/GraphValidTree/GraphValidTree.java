import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphValidTree{
	public static boolean validTree(int[][] edges, int n){
		if(n==0) return true;
		List<List<Integer>> adjacentList=new ArrayList<List<Integer>>();
		for(int i=0; i<n; i++)
			adjacentList.add(new ArrayList<Integer>());
		for(int i=0; i<edges.length; i++){
			adjacentList.get(edges[i][0]).add(edges[i][1]);
			adjacentList.get(edges[i][1]).add(edges[i][0]);
		}

		if(hasCycle(adjacentList,new boolean[n],0,-1))
			return false;
		boolean[] visited=new boolean[n];
		isConnected(adjacentList,visited,0);
		for(boolean b:visited)
			if(!b) return false;
		return true;
	}

	private static boolean hasCycle(List<List<Integer>> adjacentList, boolean[] visited, int u, int parent){
		visited[u]=true;
		for(int v:adjacentList.get(u)){
			if((visited[v] && parent!=v) || (!visited[v] && hasCycle(adjacentList,visited,v,u)))
				return true;
		}
		return false;
	}

	private static void isConnected(List<List<Integer>> adjacentList, boolean[] visited, int u){
		visited[u]=true;
		for(int v:adjacentList.get(u))
			if(!visited[v])
				isConnected(adjacentList,visited,v);
	}

	public static void main(String[] args) {
		int[][] edges={{0,1},{0,2},{0,3},{1,4}};
		int n=5;
		if(validTree(edges,n))
			System.out.println("Valid tree.");
		else
			System.out.println("Invalid tree."); 
	}
}