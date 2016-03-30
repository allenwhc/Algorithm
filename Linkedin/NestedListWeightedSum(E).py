# """
from itertools import chain
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
class NestedInteger(object):
	def __init__(self,item):
		self.item=item
		self.nestedList=[]

	def convert(self):
		pass

	def convertToNestedList(self):
		if self.isInteger():
			self.nestedList

		return nestedList

	def isInteger(self):
		"""
		@return True if this NestedInteger holds a single integer, rather than a nested list.
		:rtype bool
		"""
		return isinstance(self.item, int)

	def getInteger(self, item):
		"""
		@return the single integer that this NestedInteger holds, if it holds a single integer
		Return None if this NestedInteger holds a nested list
		:rtype int
		"""
		return self.item if self.isInteger() else None

	def getList(self, item):
		"""
		@return the nested list that this NestedInteger holds, if it holds a nested list
		Return None if this NestedInteger holds a single integer
		:rtype List[NestedInteger]
		"""
		return self.item if not self.isInteger() else None

	def printIter(self):
		pass

class Solution(object):
	def depthSum(self, nestedList):
		"""
		:type nestedList: List[NestedInteger]
		:rtype: int
		"""
		def dfs(nestItem, depth):
			if self.isInteger(nestItem):
				return self.getInteger(nestItem)*depth
			else:
				return sum(dfs(nextItem,depth+1) for nextItem in self.getList(nestItem))
		return sum(dfs(nestInt,1) for nestInt in nestedList)

	def isInteger(self, item):
		return isinstance(item,int)

	def getInteger(self, item):
		return item if self.isInteger(item) else None

	def getList(self, item):
		return item if not self.isInteger(item) else None

nestedList=[1,[4,[6]]]
sol=Solution()
print "nested weight:",sol.depthSum(nestedList)


