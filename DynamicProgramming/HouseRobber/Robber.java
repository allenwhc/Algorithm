import java.util.Arrays;

public class Robber{
	public static int rob(int[] nums){
		int n=nums.length;
		if(n==0) return 0;
		else if(n==1) return nums[0];
		int[] money=new int[n];
		money[0]=nums[0];
		money[1]=Math.max(nums[1],nums[0]);

		for(int i=2; i<n; i++){
			money[i]=Math.max(money[i-1],nums[i]+money[i-2]);
		}
		return money[n-1];
	}

	public static int rob2(int[] nums){
		int n=nums.length;
		if(n==0) return 0;
		else if(n==1) return nums[0];
		int[] dp1=new int[n];
		int[] dp2=new int[n];
		dp1[0]=0;
		dp1[1]=nums[0];
		for(int i=2; i<n; i++)
			dp1[i]=Math.max(dp1[i-1],nums[i-1]+dp1[i-2]);
		dp2[0]=0;
		dp2[1]=nums[1];
		for(int i=2; i<n; i++)
			dp2[i]=Math.max(dp2[i-1],nums[i]+dp2[i-2]);
		return Math.max(dp1[n-1],dp2[n-1]);

	}

	public static void main(String[] args) {
		int[] nums={4,1,8,10,7,5,2,3};
		System.out.println("Houses are along a straight street.");
		System.out.println("Maximum amount: "+rob(nums));
		System.out.println("Houses are along a circle.");
		System.out.println("Maximum amount: "+rob2(nums));
	}
}