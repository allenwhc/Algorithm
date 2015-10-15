import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombSum{
	//Comb Sum I
	public static List<List<Integer>> combinationSum1(int[] candidates, int target){
		List<List<Integer>> allCombSums=new ArrayList<List<Integer>>();
		if(candidates.length==0) return allCombSums;
		Arrays.sort(candidates);
		List<Integer> combSum=new ArrayList<Integer>();
		getCombSum(allCombSums,combSum,candidates,0,target,0);
		return allCombSums;
	}

	private static void getCombSum(List<List<Integer>> allCombSums, List<Integer> combSum, int[] candidates, int sum, int target, int idx){
		if(sum>target) return;
		if(sum==target){
			allCombSums.add(new ArrayList<Integer>(combSum));
			return;
		}
		for(int i=idx; i<candidates.length; i++){
			combSum.add(candidates[i]);
			getCombSum(allCombSums,combSum,candidates,sum+candidates[i],target,i);
			combSum.remove(combSum.size()-1);
		}
	}

	//Comb Sum II
	public static List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> allCombSums=new ArrayList<List<Integer>>();
		if(candidates.length==0) return allCombSums;
		Arrays.sort(candidates);
		List<Integer> combSum=new ArrayList<Integer>();
		getCombSum2(allCombSums,combSum,candidates,0,target,0);
		return allCombSums;
	}

	private static void getCombSum2(List<List<Integer>> allCombSums, List<Integer> combSum, int[] candidates, int sum, int target, int idx){
		if(sum>target) return;
		if(sum==target){
			if((allCombSums.isEmpty()) || (!allCombSums.isEmpty() && !allCombSums.contains(combSum)))
				allCombSums.add(new ArrayList<Integer>(combSum));
			return;
		}
		for(int i=idx; i<candidates.length; i++){
			combSum.add(candidates[i]);
			getCombSum2(allCombSums,combSum,candidates,sum+candidates[i],target,i+1);
			combSum.remove(combSum.size()-1);
		}
	}

	//Comb Sum III
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> allCombSums=new ArrayList<List<Integer>>();
        if(n==0 || k==0) return allCombSums;
        List<Integer> combSum=new ArrayList<Integer>();
        getCombSum3(allCombSums,combSum,k,n,0,1);
        return allCombSums;
    }

    private static void getCombSum3(List<List<Integer>> allCombSums, List<Integer> combSum, int k, int n, int sum, int idx){
    	if(sum>n || combSum.size()>k) return;
    	if(combSum.size()==k && sum==n){
    		allCombSums.add(new ArrayList<Integer>(combSum));
    		return;
    	}
    	for(int i=idx; i<=9; i++){
    		combSum.add(i);
    		getCombSum3(allCombSums,combSum,k,n,sum+i,i+1);
    		combSum.remove(combSum.size()-1);
    	}
    }

	public static void main(String[] args) {
		System.out.println("Combination Sum I (each element can be used unlimited times): ");
		int[] candidates1={2,3,6,7};
		int target1=7;
		System.out.println("All combinations sum up to "+target1+" in "+Arrays.toString(candidates1)+" are:");
		for(List<Integer> list:combinationSum1(candidates1,target1))
			System.out.println(Arrays.deepToString(list.toArray()));
		System.out.println();
		System.out.println("Combination Sum II (each element can be used only once): ");
		int[] candidates2={10,1,2,7,6,1,5};
		int target2=8;
		System.out.println("All combinations sum up to "+target2+" in "+Arrays.toString(candidates2)+" are:");
		for(List<Integer> list:combinationSum2(candidates2,target2))
			System.out.println(Arrays.deepToString(list.toArray()));
		System.out.println();
		System.out.println("Combination Sum III (add k numbers up to n): ");
		int n=9;
		int k=3;
		System.out.println("All combinations sum up to "+n+" within "+k+" numbers from 1-9 are: ");
		for(List<Integer> list:combinationSum3(k,n))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}