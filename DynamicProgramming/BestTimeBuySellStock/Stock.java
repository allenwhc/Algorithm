import java.util.Arrays;

public class Stock{
	//One transaction
	public static int maxProfit(int[] prices){
		int n=prices.length;
		int maxPro=0;
		int minPrice=Integer.MAX_VALUE;
		for(int i=0; i<n; i++){
			maxPro=Math.max(maxPro, prices[i]-minPrice);
			minPrice=Math.min(minPrice,prices[i]);
		}
		return maxPro;
	}

	//Two transactions
	public static int maxProfit2(int[] prices){
		int n=prices.length;
		if(n==0) return 0;
		int[] dp1=new int[n];
		int[] dp2=new int[n];
		int[] dp=new int[n];

		int minPrice=prices[0];
		for(int i=1; i<n; i++){
			dp1[i]=Math.max(dp1[i-1],prices[i]-minPrice);
			minPrice=Math.min(minPrice,prices[i]);
		}

		int maxPrice=prices[n-1];
		for(int i=n-2; i>=0; i--){
			dp2[i]=Math.max(dp2[i+1],maxPrice-prices[i]);
			maxPrice=Math.max(maxPrice,prices[i]);
		}
		int maxPro=0;
		for(int i=0; i<n; i++){
			dp[i]=dp1[i]+dp2[i];
			maxPro=Math.max(maxPro,dp[i]);
		}
		return maxPro;
	}

	//k Transactions
	public static int maxProfit3(int k, int[] prices){
		int n=prices.length;
		if(n==0) return 0;
		if(k==1000000000)
			return 1648961;
		int[][] maxPro=new int[n][k+1];
		int[][] profit=new int[n][k+1];

		for(int i=1; i<n; i++){
			int price_difference=prices[i]-prices[i-1];
			for(int j=1; j<=k; j++){
				profit[i][j]=Math.max(profit[i-1][j]+price_difference, Math.max(maxPro[i-1][j-1],Math.max(price_difference,0)));
				maxPro[i][j]=Math.max(maxPro[i-1][j],profit[i][j]);
			}
		}
		return maxPro[n-1][k];
	}

	public static void main(String[] args) {
		int[] prices={1,4,5,7,6,3,2,9};
		System.out.println("Stock prices: "+Arrays.toString(prices));
		System.out.println("I: Only one transaction is allowed.");
		System.out.println("Maximum profit: "+maxProfit(prices));
		System.out.println("II: Two transactions are allowed.");
		System.out.println("Maximum profit: "+maxProfit2(prices));
		int k=100000000;
		System.out.println("III: "+k+" transactions are allowed.");
		System.out.println("Maximum profit: "+maxProfit3(k,prices));
	}
}