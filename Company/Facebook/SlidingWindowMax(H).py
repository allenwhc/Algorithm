import collections
class Solution(object):
	"""
		Deque solution
		Time complexity: O(n), n is length of nums
		Extra space: O(k)
	"""
	def maxSlidingWindow(self, nums, k):
		"""
		:type nums: List[int]
		:type k: int
		:rtype: List[int]
		"""
		if len(nums)<k or not len(nums): return []
		n,res,queue=len(nums),[],collections.deque()
		for i in range(k):
			while len(queue) and nums[i]>nums[queue[-1]]:
				queue.pop()
			queue.append(i)

		for i in range(k,n):
			res.append(nums[queue[0]])
			while len(queue) and nums[i]>nums[queue[-1]]:
				queue.pop()
			while len(queue) and i-k>=queue[0]:
				queue.popleft()
			queue.append(i)
		res.append(nums[queue[0]])
		return res

nums = [7,2,4]
k=2
sol=Solution()
print sol.maxSlidingWindow(nums,k)