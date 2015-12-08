import java.util.Arrays;

public class BurstBalloons{
	public static int maxCoins(int[] nums){
		if(nums.length==0) return 0;

		int[] burstArr=new int[nums.length+2];
		int n=1;
		for(int x:nums)
			if(x>0) burstArr[n++]=x; 
		burstArr[0]=burstArr[n++]=1;
		int[][] dp=new int[n][n];
		return burst(dp,burstArr,0,n-1);
	}

	private static int burst(int[][] dp, int[] burstArr, int start, int end){
		if(start==end-1) return 0;
		if(dp[start][end]>0) return dp[start][end];
		int coins=0;
		for(int i=start+1; i<end; i++){
			coins=Math.max(coins, burstArr[start]*burstArr[i]*burstArr[end]+burst(dp,burstArr,start,i)+burst(dp,burstArr,i,end));
		}
		dp[start][end]=coins;
		return coins;
	}

	public static void main(String[] args) {
		int[] nums={3,1,5,8};
		System.out.println("Max coins: "+maxCoins(nums));
	}
}