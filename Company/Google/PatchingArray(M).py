class Solution(object):
	"""
		Greedy solution
		Time complexity: O(n), n is upper bound of the range [1,n]
		Extra space: O(1)
	"""
	def minPatches(self, nums, n):
		"""
		:type nums: List[int]
		:type n: int
		:rtype: int
		"""
		i,add_num,missed_num=0,0,1
		while missed_num<=n:
			if i<len(nums) and nums[i]<=missed_num:
				missed_num+=nums[i]
				i+=1
			else:
				missed_num+=missed_num
				add_num+=1
		return add_num

nums=[1,5,10]
n=20
sol=Solution()
print "Min # of patches:",sol.minPatches(nums,n)