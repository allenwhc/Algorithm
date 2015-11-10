import java.util.Arrays;

public class NumArray {
	private static int[] dp;
    public NumArray(int[] nums) {
        dp=new int[nums.length+1];
        dp[0]=0;
        for(int i=0; i<nums.length; i++){
            dp[i+1]=dp[i]+nums[i];
        }
    }

    public static int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }

    public static void main(String[] args) {
    	int[] nums={-2,0,3,-5,2,-1};
    	NumArray numArray=new NumArray(nums);
    	System.out.println(numArray.sumRange(0,2));
    	System.out.println(numArray.sumRange(2,5));
    	System.out.println(numArray.sumRange(0,5));
    }
}