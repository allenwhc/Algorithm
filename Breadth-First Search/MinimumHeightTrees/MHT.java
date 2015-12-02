import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class MHT{
	public static List<Integer> findMinHeightTrees(int n, int[][] edges){
		List<Integer> leaves=new ArrayList<Integer>();
		if(n==0 || edges.length==0) return leaves;
		if(n==1){
			leaves.add(0);
			return leaves;
		}
		List<Set<Integer>> adjacent_list=new ArrayList<Set<Integer>>();
		for(int i=0; i<n; i++)
			adjacent_list.add(new HashSet<Integer>());
		for(int i=0; i<edges.length; i++){
			int u=edges[i][0];
			int v=edges[i][1];
			adjacent_list.get(u).add(v);
			adjacent_list.get(v).add(u);
		}

		for(int i=0; i<n; i++)
			if(adjacent_list.get(i).size()==1) leaves.add(i);

		while(n>2){
			n-=leaves.size();
			List<Integer> newLeaves=new ArrayList<Integer>();

			for(int u:leaves){
				int v=adjacent_list.get(u).iterator().next();
				adjacent_list.get(v).remove(u);
				if(adjacent_list.get(v).size()==1) newLeaves.add(v);
			}
			leaves=newLeaves;
		}

		return leaves;
	}

	public static void main(String[] args) {
		int n=4;
		int[][] edges={{0, 1},{1, 2},{1, 3}};
		System.out.println("Roots are: "+Arrays.deepToString(findMinHeightTrees(n,edges).toArray()));
	}
}