class Solution(object):
	"""
		Brute force solution
		Time complexity: O(nk), n is length of nums, k is length of subset whose best case is O(1) and worst case is O(n)
		Extra space: O(1)
	"""
	def increasingTriplet(self, nums):
		"""
		:type nums: List[int]
		:rtype: bool
		"""
		if not nums or len(nums)<3: return False
		for i in range(1,len(nums)-1):
			less,greater=False,False
			for j in range(i-1,-1,-1):
				if nums[i]>nums[j]:
					less=True
					break
			for j in range(i+1,len(nums)):
				if nums[i]<nums[j]:
					greater=True
					break
			if less and greater: return True
		return False

	"""
		Two pointer solution
		Time complexity: O(n), n is length of nums
		Extra space: O(1)
	"""
	def increasingTriplet2(self, nums):
		"""
		:type nums: List[int]
		:rtype: bool
		"""
		if not nums or len(nums)<3: return False
		l,r=float('inf'),float('inf')
		for i in range(len(nums)):
			if nums[i]<=l:
				l=nums[i]
			elif nums[i]<=r:
				r=nums[i]
			else:
				return True
		return False

nums=[15,12,0,1,10,-10]
sol=Solution()
print nums,"exists" if sol.increasingTriplet2(nums) else "doesn't exist",'increasing triplet sequence'