import bisect
class Solution(object):
	def searchInsert(self, nums, target):
		"""
		:type nums: List[int]
		:type target: int
		:rtype: int
		"""
		pos=bisect.bisect(nums,target)
		return pos if not nums.count(target) else (pos-1)

nums=[1]
target=2
sol=Solution()
print "Insertion position:",sol.searchInsert(nums,target)
