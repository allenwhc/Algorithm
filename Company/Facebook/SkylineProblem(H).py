import heapq

class Edge(object):
	def __init__(self, x=0, y=float('inf'), isLeft=True):
		self.x=x
		self.y=y
		self.left=isLeft

class Solution(object):
	"""
		Divide-and-conquer solution
		Time complexity: O(nlogn)
		Extra space: O(n)
	"""
	def getSkyline1(self, buildings):
		# @param buildings: List[List[int]]
		# @return: List[int]
		buildings.sort(key=lambda x:x[0])
		return self.divideAndConquer(buildings,0,len(buildings)-1)
	
	def divideAndConquer(self, buildings, start, end):
		# @param buildings: List[List[int]]
		# @param start: int
		# @param end: int
		# @return: List[List[int]]
		if start==end: 
			skyline=[]
			skyline.append((buildings[start][0],buildings[start][2]))
			skyline.append((buildings[start][1], 0))
			return skyline
		mid=(end-start)/2+start
		skyline1=self.divideAndConquer(buildings,start,mid)
		skyline2=self.divideAndConquer(buildings,mid+1,end)
		return self.merge(skyline1, skyline2)
	
	def merge(self, skyline1, skyline2):
		# @param skyline1: List[List[int]]
		# @param skyline2: List[List[int]]
		# @return: List[int]
		h1,h2,i,j=0,0,0,0
		res,new_height,new_left=[],0,0
		while i<len(skyline1) and j<len(skyline2):
			if skyline1[i][0]<skyline2[j][0]:
				h1=skyline1[i][1]
				new_left=skyline1[i][0] #if new_height not in self.d else max(self.d[new_height],skyline1[i][0])
				i+=1
			elif skyline1[i][0]>skyline2[j][0]:
				h2=skyline2[j][1]
				new_left=skyline2[j][0] #if new_height not in self.d else max(self.d[new_height],skyline2[j][0])
				j+=1
			else:
				h1,h2=skyline1[i][1],skyline2[j][1]
				new_left=skyline1[i][0] #if new_height not in self.d else max(self.d[new_height],skyline1[i][0])
				i+=1
				j+=1
			new_height=max(h1,h2)
			#if res: print res[-1][1],new_height
			if res and new_height==res[-1][1]:
				prev=res.pop()
				new_left=min(prev[0],new_left)
			res.append([new_left,new_height])
	
		while i<len(skyline1): 
			res.append([skyline1[i][0],skyline1[i][1]])
			i+=1
		while j<len(skyline2): 
			res.append([skyline2[j][0],skyline2[j][1]])
			j+=1
		return res
	
	"""
		Heap solution
		Time complexity: O(nlogn)
		Extra space: O(n)
	"""

	def getSkyline2(self, buildings):
		# @param buildings: List[List[int]]
		# @return: List[List[int]]
		edges=sorted(buildings+[[b[1],float('inf'),0] for b in buildings])
		c_pts,res=[(0,float('inf'))],[]
		for L,R,H in edges:
			prev_height=c_pts[0][0]
			while c_pts and c_pts[0][1]<=L: heapq.heappop(c_pts)
			if H>0: heapq.heappush(c_pts,(-H,R))
			curr_height=c_pts[0][0]
			if prev_height!=curr_height:
				if res and res[-1][0]==L: 
					res[-1][-1]=-c_pts[0][0]
				else: res.append([L,-curr_height])
		return res

	"""
		Binary index tree solution
		Time complexity: O(nlogn)
		Extra space: O(n)
	"""

	def getSkyline3(self,buildings):
		# @param buildings: List[List[int]]
		# @return: List[List[int]]
		pass

buildings=[[2,9,10], [3,7,15], [5,12,12], [15,20,10], [19,24,8]]
print buildings
s=Solution()
print 'skyline 1:',s.getSkyline1(buildings)
print 'skyline 2:',s.getSkyline2(buildings)
print 'skyline 3:',s.getSkyline3(buildings)