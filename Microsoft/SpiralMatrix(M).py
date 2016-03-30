class Solution(object):
	"""
		Two-pointer solution
		Time complexity: O(mn), m*n is matrix size
		Extra space: O(1)
	"""
	def spiralOrder(self, matrix):
		"""
		:type matrix: List[List[int]]
		:rtype: List[int]
		"""
		if not len(matrix) or not len(matrix[0]): return []
		m,n,res=len(matrix),len(matrix[0]),[]
		left,right,top,bottom=0,n-1,0,m-1
		while True:
			for i in range(left,right+1):
				res.append(matrix[top][i])
			top+=1
			if top>bottom: break

			for i in range(top,bottom+1):
				res.append(matrix[i][right])
			right-=1
			if right<left: break

			for i in range(right,left-1,-1):
				res.append(matrix[bottom][i])
			bottom-=1
			if bottom<top: break

			for i in range(bottom, top-1, -1):
				res.append(matrix[i][left])
			left+=1
			if left>right: break

		return res

# matrix=[
#  [ 1, 2, 3 ],
#  [ 4, 5, 6 ],
#  [ 7, 8, 9 ],
#  [ 10, 11, 12]
# ] 
matrix=[[2],[3]]

print matrix
sol=Solution()
print sol.spiralOrder(matrix)