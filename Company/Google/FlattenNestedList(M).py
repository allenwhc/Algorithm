from itertools import chain
class NestedInteger(object):
	def __init__(self):
		self.item=[]

	def convertToNestedList(self,l):
		self.item.append(l)

	def isInteger(self):
		"""
		@return True if this NestedInteger holds a single integer, rather than a nested list.
		:rtype bool
		"""
		return isinstance(self.item, int)

	def getInteger(self):
		"""
		@return the single integer that this NestedInteger holds, if it holds a single integer
		Return None if this NestedInteger holds a nested list
		:rtype int
		"""
		return self.item if self.isInteger() else None

	def getList(self):
		"""
		@return the nested list that this NestedInteger holds, if it holds a nested list
		Return None if this NestedInteger holds a single integer
		:rtype List[NestedInteger]
		"""
		return self.item if not self.isInteger() else None

class NestedIterator(object):

	def __init__(self, nestedList):
		"""
		Initialize your data structure here.
		:type nestedList: List[NestedInteger]
		"""
		self.it=iter(nestedList)

	def next(self):
		"""
		:rtype: int
		"""
		print next(self.it).isInteger()

	def hasNext(self):
		"""
		:rtype: bool
		"""


	def isInteger(self,item):
		return isinstance(item,int)

	def getInteger(self,item):
		return item if self.isInteger(item) else None

	def getList(self,item):
		return item if not self.isInteger(item) else None

l=[1,[4,[6]]]
nestedList=NestedInteger()

print 'The nest list:',nestedList.item
nest,v=NestedIterator(nestedList),[]
nest.next()
# while nest.hasNext():
# 	v.append(nest.next())
print 'Flattened nested list:',v

