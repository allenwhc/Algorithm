import java.util.Arrays;

public class Longest{
	public static int lengthOfLIS(int[] nums){
		int n=nums.length;
		int[] dp=new int[n+1];

		int maxLen=0;
		for(int i=0; i<n; i++){
			int start=1;
			int end=maxLen;
			//System.out.println(Arrays.toString(dp));
			while(start<=end){
				int middle=(end-start)/2+start;
				if(nums[dp[middle]]<nums[i])
					start=middle+1;
				else end=middle-1;
			}
			int len=start;
			dp[len]=i;

			maxLen=Math.max(maxLen,len);	//Update max length
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums={10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println("Length of longest increasing sequence in "+Arrays.toString(nums)+" is: "+lengthOfLIS(nums));
	}
}