class UnionFind(object):
	def __init__(self, N):
		self.count=N
		self.id=[i for i in xrange(N)]
		self.size=[1 for i in xrange(N)]

	def __str__(self):
		return ','.join([str(x) for x in self.id])

	def union(self, P, Q):
		P,Q=self.find(P),self.find(Q)
		if not cmp(P,Q): return
		U=P if self.size[P]>self.size[Q] else Q
		V=P+Q-U
		self.id[V]=U
		self.size[U]+=self.size[V]

	def find(self, P):
		if self.id[P]==P: return P
		return self.find(self.id[P])
		# while root.parent!=root: root=root.parent
		# while self.id[P]!=P:
		# 	#self.id[P]=self.id[self.id[P]]
		# 	P=self.id[P]
		# return P

class Solution(object):
	"""
		Union find solution
		Time complexity: O(n)
		Extra space: O(n)
	"""
	def longestConsecutive(self, nums):
		# @param nums: List[int]
		# @return: int
		uf=UnionFind(len(nums))
		d=dict()
		for i, n in enumerate(nums):
			if n not in d:
				d[n]=i
				if n-1 in d: uf.union(i, d[n-1])
				if n+1 in d: uf.union(i, d[n+1])
		return max(uf.size)

nums=[100,4,200,1,3,2]
print Solution().longestConsecutive(nums)