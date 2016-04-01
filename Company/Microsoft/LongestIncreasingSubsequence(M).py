import time,bisect
class Solution(object):
	"""
		Brute force solution
		Time complexity: O(n^2), n is length of nums
		Extra space: O(1)
	"""
	def lengthOfLIS(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		if len(nums)<=1: return len(nums)
		elif len(nums)==2: return 2 if nums[1]>nums[0] else 1
		res,n=0,len(nums)
		for i in range(1,n-1):
			left_decreasing_length,right_increasing_length=0,0
			left_smallest=right_largest=nums[i]
			for j in range(i-1,-1,-1):
				if nums[j]<left_smallest:
					left_decreasing_length+=1
					left_smallest=nums[j]
			for j in range(i+1,n):
				if nums[j]>right_largest:
					right_increasing_length+=1
					right_largest=nums[j]
			res=max(res,left_decreasing_length+right_increasing_length+1)
		return res

	"""
		Binary search solution
		Time complexity: O(nlogn), n is length of nums
		Extra space: O(n)
	"""
	def lengthOfLIS2(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		if not nums: return 0
		n,dp,max_length=len(nums),[0]*(len(nums)+1),0
		for i in range(n):
			start,end=1,max_length
			while start<=end:
				mid=(end-start)/2+start
				if nums[dp[mid]]<nums[i]:
					start=mid+1
				else: end=mid-1
			max_length=start if max_length<=start else max_length
			dp[start]=i
		return max_length

	"""
		Binary search solution using bisect
		Time complexity: O(nlogn), n is length of nums
		Extra space: O(n)
	"""
	def lengthOfLIS3(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		a,x=[float('inf')]*(len(nums)+1),0
		for n in nums:
			a[bisect.bisect_left(a,n)]=n
		return a.index(float('inf'))

nums=[10, 9, 2, 5, 3, 7, 101, 18]
sol=Solution()
start_time=time.time()
print "Length of longest increasing subsequence in %s is:"%nums,sol.lengthOfLIS(nums)
print "Brute force solution runtime: %s ms" % ((time.time()-start_time)*1000)
start_time=time.time()
y=sol.lengthOfLIS2(nums)
print "Binary search solution I runtime: %s ms" % ((time.time()-start_time)*1000)
start_time=time.time()
z=sol.lengthOfLIS3(nums)
print "Binary search solution II runtime: %s ms" % ((time.time()-start_time)*1000)