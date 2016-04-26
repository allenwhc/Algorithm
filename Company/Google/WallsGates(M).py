class Solution(object):
	"""
		Breadth first search solution
		Time complexity: O(mn)
		Extra space: O(mn)
	"""
	def wallsAndGates(self, rooms):
		# @param rooms: List[int]
		# @return: None
		R=[(i,j) for i, row in enumerate(rooms) for j, col in enumerate(row) if not col]
		for x,y in R:
			for i,j in (x+1,y), (x-1,y), (x,y+1), (x,y-1):
				if i>=0 and i<len(rooms) and j>=0 and j<len(rooms[0]) and rooms[i][j]>2**30:
					rooms[i][j]=rooms[x][y]+1
					R.append((i,j))
		
		
rooms=[[float('inf'), -1, 0, float('inf')],
		[float('inf'), float('inf'), float('inf'), -1],
		[float('inf'),-1,float('inf'), -1],
  		[0, -1, float('inf'), float('inf')]]

print rooms
Solution().wallsAndGates(rooms)
print rooms