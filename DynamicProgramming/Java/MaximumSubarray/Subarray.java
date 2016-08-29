import java.util.Arrays;

public class Subarray{
	public static int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int result=Integer.MIN_VALUE;
        int sum=0;
        for(int element:nums){
        	sum+=element;
        	result=Math.max(result,sum);
        	sum=Math.max(sum,0);
        }
        return result;
    }

    public static void main(String[] args) {
    	int[] nums={-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println("Maximum sum of subarray in "+Arrays.toString(nums)+" is: "+maxSubArray(nums));
    }
}