class Solution(object):
	def countBits(self, num):
		"""
		:type num: int
		:rtype: List[int]
		"""
		res=[0,1]
		if num<2:
			return res
		

num=5
s=Solution()
print s.countBits(num)