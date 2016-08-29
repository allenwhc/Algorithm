import java.util.Arrays;

public class BuySellCool{
	public static int maxProfit(int[] prices){
		if(prices==null || prices.length==0) return 0;
		int sell=0;
		int buy=Integer.MIN_VALUE;
		int prev_buy, prev_sell=0;
		for(int price:prices){
			prev_buy=buy;
			buy=Math.max(prev_buy,prev_sell-price);
			prev_sell=sell;
			sell=Math.max(prev_sell,prev_buy+price);
		}
		return sell;
	}

	public static void main(String[] args) {
		int[] prices={1,2,3,0,2};
		System.out.println("Maximum profit is: "+maxProfit(prices));
 	}
}