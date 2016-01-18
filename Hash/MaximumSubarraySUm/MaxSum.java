import java.util.HashMap;
import java.util.Arrays;

public class MaxSum{
	public static int maxSubArrayLen(int[] nums, int k){
		int n=nums.length;
		if(n==0) return 0;
		int len=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int sum=0;
		for(int i=0; i<n; i++){
			sum+=nums[i];
			if(sum==k) len=i+1;
			else if(map.containsKey(sum-k)) len=Math.max(len,map.get(sum-k));
			if(!map.containsKey(sum)) map.put(sum,i); 
		}
		return len;
	}

	public static void main(String[] args) {
		int[] nums={1,-1,5,-2,3};
		int k=3;
		System.out.println("Max length = "+maxSubArrayLen(nums,k));
	}
}