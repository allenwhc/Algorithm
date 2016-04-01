class Solution(object):
	"""
		Breadth-first search solution
		Time complexity: O(mn) m,n is size of grid
		Extra space: O(1)
	"""
	def numIslands(self, grid):
		"""
		:type grid: List[List[str]]
		:rtype: int
		"""
		m,n,count=len(grid),len(grid[0]),0
		if not m or not n: return 0
		for i in range(m):
			for j in range(n):
				if grid[i][j]=='1':
					count+=1
					self.bfs(grid,m,n,i,j)
		return count

	def bfs(self,grid,m,n,x,y):
		if x<0 or x>=m or y<0 or y>=n: return
		if grid[x][y]=='1':
			grid[x][y]='*'
			self.bfs(grid,m,n,x-1,y)
			self.bfs(grid,m,n,x+1,y)
			self.bfs(grid,m,n,x,y-1)
			self.bfs(grid,m,n,x,y+1)

	"""
		Naive union find solution
		Time complexity: O(nk), n is size of positions, k is # of ops
		Extra space: O(k)
	"""
	# def numIslands2(self, m, n, positions):
	# 	"""
	# 	:type m: int
	# 	:type n: int
	# 	:type positions: List[List[int]]
	# 	:rtype: List[int]
	# 	"""
	# 	if not m or not n or not len(positions): return 0
	# 	directions=[0,-1,0,1,0]
	# 	parents=[-1]*(m*n)
	# 	count,result=0,[]
	# 	for (start_x,start_y) in positions:
	# 		parents[start_x*n+start_y]=start_x*n+start_y
	# 		count+=1
	# 		for i in range(len(directions)-1):
	# 			x,y=start_x+directions[i],start_y+directions[i+1]
	# 			if 0<=x<m and 0<=y<n and parents[x*n+y]!=-1:
	# 				neighbor=self.union_find(parents,x*n+y)
	# 				if neighbor != start_x*n+start_y:
	# 					parents[neighbor]=start_x*n+start_y
	# 					count-=1
	# 		result.append(count)
	# 	return result

	# def union_find(self, parents, root):
	# 	"""
	# 	:type parents: List[int]
	# 	:type root: int
	# 	:rtype: int
	# 	"""
	# 	while parents[root]!=root:
	# 		root=parents[root]
	# 	return root

	"""
		Compression union find solution
		Time complexity: O((n+k)*logn), n is size of positions, k is # of ops
		Extra space: 
	"""
	def __init__(self):
		self.count=0
		self.id={}
		self.size={}

	def numIslands2(self, m, n, positions):
		"""
		:type m: int
		:type n: int
		:type positions: List[List[int]]
		:rtype: List[int]
		"""
		res=[]
		for p in map(tuple,positions):
			self.add(p)
			for d in [[0,-1],[-1,0],[0,1],[1,0]]:
				q=(p[0]+d[0],p[1]+d[1])
				if q in self.id:
					self.union(p,q)
			res.append(self.count)
		return res

	def add(self, root):
		"""
		:type root: int
		:rType: int
		"""
		self.id[root]=root
		self.size[root]=1
		self.count+=1

	def find(self,root):
		"""
		:type root: int
		:rType: int
		"""
		while self.id[root]!=root:
			self.id[root]=self.id[self.id[root]]
			root=self.id[root]
		return root

	def union(self,root1,root2):
		"""
		:type root1: int
		:type root2: int
		:rType: None
		"""
		i,j=self.find(root1),self.find(root2)
		if i==j: return # i,j are in the same set
		if self.size[i]>self.size[j]: i, j = j, i
		self.size[j]+=self.size[i]
		self.id[i]=j
		self.count-=1

grid=[
	['1','1','0','0','0'],
	['1','1','0','0','0'],
	['0','0','1','0','0'],
	['0','0','0','1','1']
]

for g in grid:
	print g
sol=Solution()
print "# of islands:",sol.numIslands(grid)
m,n,positions =3,3,[[0,0], [0,1], [1,2], [2,1]]
print "size of grid:",m,"x",n,", land positions:",positions
print "# of islands:",sol.numIslands2(m,n,positions)
