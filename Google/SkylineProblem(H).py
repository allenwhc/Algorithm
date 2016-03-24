import heapq
import sys

class Solution:
	"""
		Heap solution
		Time complexity: O(nlogn), n is # of buildings
		Extra space: O(n)
	"""
	def getSkyline(self, buildings):
		# @param buildings: List[List[int]]
		# @return: List[List[int]]
		if not len(buildings): return []
		outlines=sorted(buildings+[[b[1],sys.maxint,0] for b in buildings])
		skyline,turning_pts=[],[(0,sys.maxint)]
		for L, R, H in outlines:
			top=turning_pts[0][0]
			while turning_pts[0][1]<=L:
				heapq.heappop(turning_pts)
			if H>0:
				heapq.heappush(turning_pts,(-H,R))
			if top!=turning_pts[0][0]:
				if skyline and skyline[-1][0]==L:
					skyline[-1][-1]=-turning_pts[0][0]
				else:
					skyline.append([L,-turning_pts[0][0]])
		return skyline

buildings=[[3,7,15], [2,9,10],  [5,12,12], [15,20,10], [19,24,8]]
print "Building coordinates:",
for b in buildings:
	print b,
sol=Solution()
print "Building outlines"
for o in sol.getSkyline(buildings):
	print o,