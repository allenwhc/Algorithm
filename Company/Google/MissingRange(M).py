class Solution(object):
	"""
		Greedy solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def findMissingRanges(self, nums, lower, upper):
		"""
		:type nums: List[int]
		:type lower: int
		:type upper: int
		:rtype: List[str]
		"""
		def convertToRange(lower,upper):
			return str(lower) if lower==upper else str(lower)+'->'+str(upper)
		if not nums: return [convertToRange(lower,upper)]
		res,prev=[],0
		if lower<nums[0]:
			res.append(convertToRange(lower,nums[0]-1))
			prev=nums[0]
		else: prev=lower
		for n in nums:
			if prev+1<n:
				res.append(convertToRange(prev+1,n-1))
			prev=n
		if upper>prev:
			res.append(convertToRange(prev+1,upper))
		return res

nums=[0, 1, 3, 50, 75]
lower,upper=-10,100
sol=Solution()
print "Missing range from [",lower,',',upper,'] in',nums,'is:',sol.findMissingRanges(nums,lower,upper)