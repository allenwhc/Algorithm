import copy
class Solution(object):
	def rotate(self, matrix):
		"""
		:type matrix: List[List[int]]
		:rtype: void Do not return anything, modify matrix in-place instead.
		"""
		matrix[::]=map(list,zip(*matrix[::-1]))
		

matrix=[[1,2,3],[4,5,6],[7,8,9]]
print "original"
for m in matrix:
	print m
sol=Solution()
sol.rotate(matrix)
print "rotated:"
for m in matrix:
	print m