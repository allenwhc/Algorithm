class Vector2D(object):
	def __init__(self, vec2d):
		"""
		Initialize your data structure here.
		:type vec2d: List[List[int]]
		"""
		self.vec=vec2d
		self.row=0
		self.col=0

	def next(self):
		"""
		:rtype: int
		"""
		res=self.vec[self.row][self.col]
		self.col+=1
		return res

	def hasNext(self):
		"""
		:rtype: bool
		"""
		while self.row<len(self.vec):
			if self.col<len(self.vec[self.row]):
				return True
			self.row+=1
			self.col=0
		return False
	
# Your Vector2D object will be instantiated and called as such:
vec2d=[
  [1,2],
  [3],
  [4,5,6]
]
i, v = Vector2D(vec2d), []
while i.hasNext(): v.append(i.next())
print v