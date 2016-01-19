import java.util.Arrays;

public class CoinChange{
	public static int coinChange(int[] coins, int amount){
		int n=coins.length;
		if(n==0) return 0;
		int[] dp=new int[amount+1];
		for(int i=1; i<=amount; i++) dp[i]=Integer.MAX_VALUE;
		for(int i=1; i<=amount; i++){
			for(int j=0; j<n; j++){
				if(coins[j]<=i){
					int res_amount=dp[i-coins[j]];
					if(res_amount!=Integer.MAX_VALUE && res_amount+1<dp[i])
						dp[i]=res_amount+1;
				}
			}
		}
		if(dp[amount]==Integer.MAX_VALUE) return -1;
		return dp[amount];
	}

	public static void main(String[] args) {
		int[] coins={2};
		int amount=3;
		System.out.println("Minimum # of changes: "+coinChange(coins,amount));
	}
}