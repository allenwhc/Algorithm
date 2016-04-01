import copy
class Solution(object):
	def rotate1(self, matrix):
		"""
		:type matrix: List[List[int]]
		:rtype: void Do not return anything, modify matrix in-place instead.
		"""
		matrix[::]=map(list,zip(*matrix[::-1]))

	def rotate2(self, matrix):
		"""
		:type matrix: List[List[int]]
		:rtype: void Do not return anything, modify matrix in-place instead.
		"""
		matrix[::]=map(list,zip(*matrix))[::-1]

matrix1=[[1,2,3],[4,5,6],[7,8,9]]
matrix2=[[1,2,3],[4,5,6],[7,8,9]]
print "original"
for m in matrix1:
	print m
sol=Solution()
sol.rotate1(matrix1)
print "rotated 90 clockwise:"
for m in matrix1:
	print m
sol.rotate2(matrix2)
print "rotated 90 counter-clockwise:"
for m in matrix2:
	print m
