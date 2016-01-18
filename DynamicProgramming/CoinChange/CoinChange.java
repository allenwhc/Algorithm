import java.util.Arrays;

public class CoinChange{
	public static int coinChange(int[] coins, int amount){
		int n=coins.length;
		if(n==0) return 0;
		int[] dp=new int[amount+1];
		for(int i=1; i<=amount; i++){
			for(int j=0; j<n; j++){
				if(coins[j]<=i){
					
				}
			}
		}
		return dp[m-1];
	}

	public static void main(String[] args) {
		int[] coins={2,5,3,6};
		int amount=10;
		System.out.println("Minimum # of changes: "+coinChange(coins,amount));
	}
}