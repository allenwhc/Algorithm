import sys
class Solution(object):
	def maxProfit(self, prices):
		"""
		:type prices: List[int]
		:rtype: int
		"""
		if len(prices)==0:
			return 0
		buy,sell,prev_buy,prev_sell=-sys.maxint,0,0,0
		for price in prices:
			prev_buy=buy
			buy=max(prev_buy,prev_sell-price)
			prev_sell=sell
			sell=max(prev_sell,prev_buy+price)
		return sell
		
prices=[1,2,3,0,2]
s=Solution()
print "Max profit:",s.maxProfit(prices) 