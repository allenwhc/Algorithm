public class BestTimeBuySellStock{
	public static int maxProfit(int[] prices){
		int maxProfit=0;
		int minPrice=Integer.MAX_VALUE;

		for(int i=0; i<prices.length; i++){
			maxProfit=Math.max(maxProfit,prices[i]-minPrice);
			minPrice=Math.min(minPrice,prices[i]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices={10,2,7,3,5,6,11,4,1,17};
		System.out.println(maxProfit(prices));
	}
}