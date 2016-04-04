import bisect
class Solution(object):
	"""
		Binary search solution
		Time complexity: O(logn), n is length of nums
		Extra space: O(1)
	"""
	def search(self, nums, target):
		"""
		:type nums: List[int]
		:type target: int
		:rtype: int
		"""
		if not nums: return 0
		s,e=0,len(nums)-1
		while s<=e:
			mid=(e-s)/2+s
			if nums[mid]==target: return mid
			if nums[s]<=nums[mid]:
				if nums[s]<=target<nums[mid]: e=mid-1
				else: s=mid+1
			else:
				if nums[mid]<target<=nums[e]: s=mid+1
				else: e=mid-1
		return -1

nums=[2,3,4,5,6,7,0,1]
target=1
sol=Solution()
print "index of",target,"is:",sol.search(nums,target)