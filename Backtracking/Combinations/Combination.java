import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Combination{
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> allComb=new ArrayList<List<Integer>>();
		List<Integer> comb=new ArrayList<Integer>();
		int[] nums=new int[n];
		for(int i=0; i<n; i++)
			nums[i]=i+1;
		if(nums.length==0) return allComb;
		getCombination(allComb,comb,nums,0,k);
		return allComb;
	}

	private static void getCombination(List<List<Integer>> allComb, List<Integer> comb, int[] nums, int step, int k){
		if(comb.size()==k){
			allComb.add(new ArrayList(comb));
			return;
		}

		for(int i=step; i<nums.length; i++){
			comb.add(nums[i]);
			getCombination(allComb,comb,nums,i+1,k);	
			comb.remove(comb.size()-1);	
		}
	}

	public static void main(String[] args) {
		int n=16;
		int k=7;
		System.out.println("C("+n+","+k+")="+combine(n,k).size());
		System.out.println("All possible results of C("+n+","+k+") are:");
		for(List<Integer> list:combine(n,k))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}