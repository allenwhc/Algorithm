class Solution(object):
	def validTree(self, n, edges):
		"""
		:type n: int
		:type edges: List[List[int]]
		:rtype: bool
		"""
		adjacent_list=[[] for i in range(n)]
		for e in edges:
			adjacent_list[e[0]].append(e[1])
			adjacent_list[e[1]].append(e[0])
		if self.hasCycle(adjacent_list,0,-1,[False for i in range(n)]):
			return False
		visited=[False for i in range(n)]
		self.isConnected(adjacent_list,0,visited)
		return False if False in visited else True

	def hasCycle(self,adjacent_list,u,p,visited):
		visited[u]=True
		for v in adjacent_list[u]:
			if (visited[v] and p!=v) or (not visited[v] and self.hasCycle(adjacent_list,v,u,visited)):
				return True
		return False

	def isConnected(self,adjacent_list,u,visited):
		visited[u]=True
		for v in adjacent_list[u]:
			if not visited[v]:
				self.isConnected(adjacent_list,v,visited)

n = 2
edges = [[1,0]]
sol=Solution()
print sol.validTree(n,edges)