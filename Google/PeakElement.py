class Solution(object):
	def findPeakElement(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		if len(nums)<=1:
			return 0
		return self.binary_search(nums,0,len(nums)-1)

	def binary_search(self,nums,s,e):
		if s<=e:
			mid=(e-s)/2+s
			if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
				return mid
			if mid>0 and nums[mid]<nums[mid-1]:
				return self.binary_search(nums,s,mid)
			if mid<len(nums) and nums[mid]<nums[mid+1]:
				return self.binary_search(nums,mid+1,e)
		return -1

nums=[1,2]
s=Solution()
print "peak element:", s.findPeakElement(nums)