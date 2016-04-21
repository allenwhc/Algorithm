class NumMatrix(object):
	def __init__(self, matrix):
		self.m=len(matrix)
		self.n=len(matrix[0])
		self.tree=self.num=[[0 for j in xrange(n+1)] for i in xrange(m+1)]
		self.update((i,j,matrix[i][j] for j in xrange(n+1)) for i in xrange(m+1))

	def update(self, row, col, val):
		if not self.m or not self.n: return


	def sumRegion(self, row1, col1, row2, col2):
		pass

matrix=[[3, 0, 1, 4, 2],
  		[5, 6, 3, 2, 1],
  		[1, 2, 0, 1, 5],
  		[4, 1, 0, 1, 7],
  		[1, 0, 3, 0, 5]]
for m in matrix:
	print m
numMatrix=NumMatrix(matrix)
print numMatrix.sumRegion(2,1,4,3)
numMatrix.update(3,2,2)
print numMatrix.sumRegion(2,1,4,3)