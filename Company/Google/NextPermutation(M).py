from collections import Counter
import bisect
class Solution(object):
	def permute(self, nums):
		# @param nums: List[int]
		# @return: List[List[int]]
		permutation=[]

		def backtracking(nums, permutation, l, r):
			if l==r:
				permutation.append([x for x in nums])
				return
			for i in xrange(l,r+1):
				nums[l],nums[i]=nums[i],nums[l]
				backtracking(nums,permutation,l+1,r)
				nums[l],nums[i]=nums[i],nums[l]
		backtracking(nums,permutation,0,len(nums)-1)
		return permutation

	def permute2(self,nums):
		# @param nums: List[int]
		# @return: List[List[int]]
		permutation=[[]]
		for n in nums:
			permutation=[p[:i]+[n]+p[i:] 
						for p in permutation 
						for i in xrange((p+[n]).index(n)+1)]
		return permutation


	def nextPermutation(self, nums):
		# @param nums: List[int]
		# @return: None
		n=len(nums)
		i=j=n-1
		while i>0 and nums[i-1]>=nums[i]: i-=1
		if i<=0:
			nums.sort()
			return
		while nums[j]<=nums[i-1]: j-=1
		nums[i-1],nums[j]=nums[j],nums[i-1]
		nums+=nums[:i]+nums[i:][::-1]
		del nums[:n]

nums=[1,3,2,1,1,0]
permutation=Solution().permute2(nums)
print 'Permutation of',nums,'and its next permutation:'
for p in permutation: 
	print p,'->',
	Solution().nextPermutation(p)
	print p