class Solution(object):
	"""
		Bottom-up recursive DP solution
		Time complexity: O(n^3)
		Space complexity: O(n^2)
	"""
	# def maxCoins(self, nums):
	# 	"""
	# 	:type nums: List[int]
	# 	:rtype: int
	# 	"""
	# 	if len(nums)==0: return 0
	# 	coins=[0 for i in range(len(nums)+2)]	# Create a coin list with n+2 elements
	# 	n=1 # number of 'valid' balloons whose coin is greater than 0
	# 	for coin in nums:
	# 		if coin>0:
	# 			coins[n]=coin 	# if coin<=0, skip that balloon
	# 			n+=1
	# 	coins[0],coins[n]=1,1	# set nums[-1]=nums[n]=1
	# 	n+=1
	# 	dp=[[0 for i in range(n)] for i in range(n)] # create dp of size=n*n
	# 	return self.wrapper(coins,dp,0,n-1)

	# def wrapper(self,coins,dp,left,right):
	# 	"""
	# 	:type coins: List[int], dp: List[List[int]], left: int, right: int
	# 	:rType: int
	# 	"""
	# 	if right-left==1: return 0	# reach the last balloon
	# 	if dp[left][right]>0: return dp[left][right]
	# 	curr_max_coins=0
	# 	for i in range(left+1,right):
	# 		curr_max_coins=max(curr_max_coins, 
	# 							coins[left]*coins[i]*coins[right]	# Suppose coins[i] is the last balloon to burst
	# 							+self.wrapper(coins,dp,left,i)	# Use divide-and-conquer
	# 							+self.wrapper(coins,dp,i,right))
	# 	dp[left][right]=curr_max_coins
	# 	return curr_max_coins

	"""
		Bottom-up iterative DP Solution
		Time complexity: O(n^2)
		Space complexity: O(n^2)
	"""
	def maxCoins(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		nums=[1]+nums+[1]
		n=len(nums)
		dp=[[0 for i in range(n)] for i in range(n)]
		for m in range(2,n):	# control balloon gaps from 2 ~ n-1
			for left in range(n-m):	# balloon on the left starts at 0
				right=left+m  	# balloon on the right ends at left+gap
				for i in range(left+1,right):	# burst all balloons in the gap (left,right)
					# Suppose you're bursting ith balloon which is the last balloon to burst.
					# Then you gain coins: nums[left]*nums[i]*nums[right]
					# All coins you've already got is: dp[left][i] + dp[i][right] (coins you got on the left and right)
					# So total coins is: nums[left]*nums[i]*nums[right]+dp[left][i]+dp[i][right]
					dp[left][right]=max(dp[left][right],nums[left]*nums[i]*nums[right]+dp[left][i]+dp[i][right])
		return dp[0][-1]
nums=[3,1,5,8]
sol=Solution()
print "Max coins:",sol.maxCoins(nums)