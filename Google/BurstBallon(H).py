class Solution(object):
	def maxCoins(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		if len(nums)==0: return 0
		n=1
		dp=[[0]*i for i in n]
		print dp

nums=[3,1,5,8]
sol=Solution()
print "Max coins:",sol.maxCoins(nums)