import java.util.HashMap;
import java.util.Arrays;

public class MaxSum{
	public static int maxSubArrayLen(int[] nums, int k){
		int n=nums.length;
		if(n==0) return 0;
		int len=0;
		for(int i=1; i<n; i++) nums[i]=nums[i]+nums[i-1];
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(0,-1);
		int sum=0;
		for(int i=0; i<n; i++){
			if(map.containsKey(nums[i]-k))
				len=Math.max(len,i-map.get(nums[i]-k));
			if(!map.containsKey(nums[i]))
				map.put(nums[i],i);
		}
		return len;
	}

	public static void main(String[] args) {
		int[] nums={-1,1};
		int k=1;
		System.out.println("Max length = "+maxSubArrayLen(nums,k));
	}
}