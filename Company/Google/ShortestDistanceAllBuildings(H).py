import collections
class Solution(object):
	def shortestDistance(self, grid):
		"""
		:type grid: List[List[int]]
		:rtype: int
		"""
		if len(grid)==0 or len(grid[0])==0: return 0
		m,n,num_total_buildings=len(grid),len(grid[0]),sum(val for line in grid for val in line if val==1)
		times_spot_picked, distance_to_all_buildings=[[0]*n for i in range(m)], [[0]*n for i in range(m)]

		def bfs(x,y):
			"""
			:type x: int, y: int
			:rtype: bool
			"""
			visited=[[False]*n for r in range(m)]
			visited[x][y],count_buildings,queue=True,1,collections.deque([(x,y,0)])
			while queue:
				curr_x, curr_y, curr_total_distance=queue.popleft()
				for i, j in ((curr_x-1,curr_y),(curr_x+1,curr_y),(curr_x,curr_y-1),(curr_x,curr_y+1)):
					if 0<=i<m and 0<=j<n and not visited[i][j]:
						visited[i][j]=True
						if grid[i][j]==0:
							queue.append((i,j,curr_total_distance+1))
							times_spot_picked[i][j]+=1
							distance_to_all_buildings[i][j]+=curr_total_distance+1
						elif grid[i][j]==1:
							count_buildings+=1
			return True if count_buildings==num_total_buildings else False

		for i in range(0,m):
			for j in range(0,n):
				if grid[i][j]==1:
					if not bfs(i,j): return -1
					
		return min([distance_to_all_buildings[i][j] for i in range(m) for j in range(n) if not grid[i][j] and times_spot_picked[i][j]==num_total_buildings] or [-1] )
		
grid=[[1,0,2,0,1],
	[0,0,0,0,0],
	[0,0,1,0,0]]
for g in grid:
	print g
s=Solution()
print "Min distance: ",s.shortestDistance(grid)