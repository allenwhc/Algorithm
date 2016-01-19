import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class ConnectComponent{
	public static int countComponents(int n, int[][] edges){
		List<List<Integer>> adjacent_list=new ArrayList<List<Integer>>();
		for(int i=0; i<n; i++)
			adjacent_list.add(new ArrayList<Integer>());
		for(int i=0; i<edges.length; i++){
			int u=edges[i][0];
			int v=edges[i][1];
			adjacent_list.get(u).add(v);
			adjacent_list.get(v).add(u);
		}
		// for(List<Integer> list:adjacent_list)
		// 	System.out.println(Arrays.deepToString(list.toArray()));
		boolean[] visited=new boolean[n];
		Queue<Integer> queue=new LinkedList<Integer>();
		int count=0;
		for(int i=0; i<n; i++) queue.offer(i);
		while(!queue.isEmpty()){
			if(visited[queue.peek()]) {
				queue.poll();
				continue;
			}
			int u=queue.poll();
			isConnected(adjacent_list,visited,u);
			count++;
		}
		return count;
	}

	private static void isConnected(List<List<Integer>> adjacent_list, boolean[] visited, int u){
		visited[u]=true;
		for(int v:adjacent_list.get(u))
			if(!visited[v]) isConnected(adjacent_list,visited,v);
	}

	public static void main(String[] args) {
		int n=5;
		int[][] edges={{0, 1},{1, 2},{2,3},{3, 4}};
		System.out.println("# of connected components: "+countComponents(n,edges));
	}
}