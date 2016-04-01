import bisect
class Solution(object):
	"""
		Two pointer solution
		Time complexity: O(n), n is length of nums
		Extra space: O(1)
	"""
	def minSubArrayLen(self, s, nums):
		"""
		:type s: int
		:type nums: List[int]
		:rtype: int
		"""
		min_length,curr_sum,l,r=float('inf'),0,0,0
		while r<len(nums):
			while r<len(nums) and curr_sum<s:
				curr_sum+=nums[r]
				r+=1
			if curr_sum>=s:
				while l<r and curr_sum>=s:
					curr_sum-=nums[l]
					l+=1
				min_length=min(min_length,r-l+1)
		return min_length if min_length!=float('inf') else 0

	"""
		Binary search solution
		Time complexity: O(nlogn)
		Extra space: O(1)
	"""
	def minSubArrayLen2(self, s, nums):
		"""
		:type s: int
		:type nums: List[int]
		:rtype: int
		"""
		start,end,n,min_length=1,len(nums),len(nums),0
		def checkSum(s,nums,length):
			curr_sum=0
			for i in range(len(nums)):
				if i>=length: curr_sum-=nums[i-length]
				curr_sum+=nums[i]
				if curr_sum>=s: return True
			return False
		while start<=end:
			m=(end-start)/2+start
			if checkSum(s,nums,m):
				min_length=m
				end=m-1
			else: start=m+1
		return min_length

nums=[1,1]
s=3
sol=Solution()
print "min size array:",sol.minSubArrayLen2(s,nums)