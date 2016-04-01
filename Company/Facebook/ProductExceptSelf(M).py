class Solution(object):
	"""
		Time complexity: O(n), n is length of nums
		Extra space: O(1)
	"""
	def productExceptSelf(self, nums):
		"""
		:type nums: List[int]
		:rtype: List[int]
		"""
		n=len(nums)
		if not n: return []
		res,temp=[1 for i in range(n)],1
		for i in range(n):
			res[i]=temp
			temp*=nums[i]
		temp=1
		for i in range(n-1,-1,-1):
			res[i]*=temp
			temp*=nums[i]
		return res


nums=[1,2,3,4,5]
sol=Solution()
print "product:",sol.productExceptSelf(nums)