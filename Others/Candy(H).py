class Solution(object):
	def candy(self, ratings):
		res,dp=0,[1 for i in xrange(len(ratings))]
		for i in xrange(1, len(dp)):
			if ratings[i]>ratings[i-1]: dp[i]=dp[i-1]+1
		for i in xrange(len(dp)-2, -1, -1):
			if ratings[i]>ratings[i+1]: dp[i]=max(dp[i],dp[i+1]+1)
		return sum(dp)

ratings=[4,2,3,4,1]
print Solution().candy(ratings)