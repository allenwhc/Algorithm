
class Solution(object):
	"""
		Time complexity: O(mn), m*n is size of matrix
		Extra space: O(1)
	"""
	def setZeroes(self, matrix):
		"""
		:type matrix: List[List[int]]
		:rtype: void Do not return anything, modify matrix in-place instead.
		"""
		m,n=len(matrix),len(matrix[0])
		is_clear_first_row,is_clear_first_col=True if matrix[0].count(0) else False, True if zip(*matrix)[0].count(0) else False
		for i in range(1,m):
			for j in range(1,n):
				if not matrix[i][j]:
					matrix[i][0]=matrix[0][j]=0
		for y in range(1,n):
			if not matrix[0][y]:
				for x in range(1,m):
					matrix[x][y]=0
		for x in range(1,m):
			if not matrix[x][0]:
				for y in range(1,n):
					matrix[x][y]=0
		matrix[0]=[0 for i in range(n)] if is_clear_first_row else matrix[0]
		if is_clear_first_col:
			for i in range(m):
				matrix[i][0]=0

matrix=[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]

print "original:"
for m in matrix:
	print m
sol=Solution()
sol.setZeroes(matrix)
print "set:"
for m in matrix:
	print m