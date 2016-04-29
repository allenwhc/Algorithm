class Solution(object):
	"""
		Dynamic programming solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def maxSubarray1(self, nums):
		# @param nums: List[int]
		# @return: int
		n,maxSum,currSum=len(nums),-float('inf'),0
		for num in nums:
			currSum=max(currSum+num,num)
			maxSum=max(maxSum,currSum)
			currSum=max(currSum,num)
		return maxSum

	"""
		Divide-and-conquer solution
		Time complexity: O(nlogn)
		Extra space: O(1)
	"""
	def maxSubarray2(self,nums):
		# @param nums: List[int]
		# @return: int
		return self.divideAndConquer(nums,0,len(nums)-1)

	def divideAndConquer(self, nums, L, R):
		# @param nums: List[int]
		# @param L,R: int
		# @return: int
		if L==R: return nums[L]
		M=(L+R)/2
		def crossMaxSum(nums,L,M,R):
			currSum,left_sum,right_sum=0,-float('inf'),-float('inf')
			for i in xrange(M,L-1,-1):
				currSum+=nums[i]
				left_sum=max(left_sum,currSum)
			currSum=0
			for i in xrange(M+1,R+1):
				currSum+=nums[i]
				right_sum=max(right_sum,currSum)
			return left_sum+right_sum
		return max(self.divideAndConquer(nums,L,M),self.divideAndConquer(nums,M+1,R),crossMaxSum(nums,L,M,R))

nums=[-2,1,-3,4,-1,2,1,-5,4]
print 'Largest sum of subarray in [%s] is: %d'%(','.join([str(x) for x in nums]),Solution().maxSubarray2(nums))