from collections import Counter
from operator import itemgetter
from itertools import chain
class Solution(object):
	"""
		Hash table solution
	"""
	def topKFrequent(self, nums, k):
		# @param nums: List[int]
		# @param k: int
		# @return: List[int]
		return list(zip(*sorted(Counter(nums).items(), key=itemgetter(1),reverse=True)[0:k])[0])

	"""
		Bucket sort solution
	"""
	def topKFrequent1(self, nums, k):
		bucket = [[] for _ in nums]
		for num, freq in Counter(nums).items():
			bucket[len(nums) - freq].append(num)
		return list(chain(*bucket))[:k]

nums=[1,1,1,2,2,3]
k=2
print Solution().topKFrequent1(nums,k)