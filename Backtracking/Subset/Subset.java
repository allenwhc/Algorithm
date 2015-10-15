import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subset{
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> allSubsets=new ArrayList<List<Integer>>();
		allSubsets.add(new ArrayList<Integer>());
		if(nums.length==0) return allSubsets;
		List<Integer> subset=new ArrayList<Integer>();
		Arrays.sort(nums);
		getAllSubsets(allSubsets,subset,nums,0);
		return allSubsets;
	}

	private static void getAllSubsets(List<List<Integer>> allSubsets, List<Integer> subset, int[] nums, int step){
		if(step==nums.length){
			return;
		}

		for(int i=step; i<nums.length; i++){
			subset.add(nums[i]);
			if((allSubsets.size()==0) || (!allSubsets.isEmpty() && !allSubsets.contains(subset)))
				allSubsets.add(new ArrayList<Integer>(subset));
			getAllSubsets(allSubsets,subset,nums,i+1);
			subset.remove(subset.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] nums={4,2,2,1,5};
		System.out.println("All subsets of "+Arrays.toString(nums)+" are: ");
		for(List<Integer> list:subsets(nums))
			System.out.println(Arrays.deepToString(list.toArray()));

	}
}