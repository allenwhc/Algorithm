import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FactorComb{
	public static List<List<Integer>> getFactors(int n){
		List<List<Integer>> allFactors=new ArrayList<List<Integer>>();
		List<Integer> factors=new ArrayList<Integer>();
		if(n<=1) return allFactors;
		generate(allFactors,factors,n,2);
		return allFactors;
	}

	private static void generate(List<List<Integer>> allFactors, List<Integer> factors, int n, int k){
		if(n<=1){
			if(factors.size()>=2)
				allFactors.add(new ArrayList<Integer>(factors));
			return;
		}
		for(int i=k; i<=n; i++){
			if(n%i==0){
				factors.add(i);
				generate(allFactors,factors,n/i,i);
				factors.remove(factors.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums={12,17,32,45};
		for(int i=0; i<nums.length; i++){
			System.out.println("All factors of "+nums[i]+" are: ");
			for(List<Integer> list:getFactors(nums[i]))
				System.out.println(Arrays.deepToString(list.toArray()));
			System.out.println();
		}
	}
}