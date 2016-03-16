class Solution(object):
	def threeSumSmaller(self, nums, target):
		"""
		:type nums: List[int]
		:type target: int
		:rtype: int
		"""
		if len(nums)<3:
			return 0
		nums.sort()
		res=0
		for i in range(0,len(nums)-2):
			if nums[i]*3>=target:
				return res
			j=i+1
			k=len(nums)-1
			while j<k:
				if nums[i]+nums[j]+nums[k]<target:
					res+=k-j
					j+=1
				else:
					k-=1
		return res

nums=[-2,3,1,0]
target=2
s=Solution()
print s.threeSumSmaller(nums,target)