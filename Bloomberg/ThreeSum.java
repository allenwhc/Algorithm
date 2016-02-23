import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum{
	public static List<List<Integer>> threeSum(int[] nums){
		int n=nums.length;
		if(n<3) return new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		int i,j,k;

		for(i=0; i<n-2; i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			j=i+1;
			k=n-1;
			while(j<k){
				int sum=nums[i]+nums[j]+nums[k];
				if(sum<0) j++;
				else if(sum>0) k--;
				else{
					result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
					j++;k--;
					while(j<k && nums[j]==nums[j-1]) j++;
					while(j<k && nums[k]==nums[k+1]) k--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums={-1,0,1,2,-1,-4};

		for(List<Integer> list:threeSum(nums)){
			System.out.println(Arrays.deepToString(list.toArray()));
		}
	}
}