class Solution(object):
	""" 
		Breadth-First Search Method:
		Space complexity: O(1)
		Time complexity: O(mn)	

	def minArea(self, image, x, y):
		
		# :type image: List[List[str]]
		# :type x: int
		# :type y: int
		# :rtype: int
		
		if len(image)==0 or len(image[0])==0: return 0
		m,n=len(image),len(image[0])
		area=[[x,y],[x,y]] # area[0] indicates bottom-leftmost point, area[1] indicates top-rightmost point
							# starting from (x,y)
		# self.findMinArea(image,m,n,x,y,area) 

		return (area[0][0]-area[1][0]+1)*(area[1][1]-area[0][1]+1)


	def findMinArea(self, image, m, n, x, y, area):
		if x<0 or x>=m or y<0 or y>=n: return # if out of bound, return
		if image[x][y]=='0': return	 # if encounters white pixel, return

		image[x][y]='0'	# change visited black pixel to white
		area[0][0]=max(area[0][0],x)
		area[0][1]=min(area[0][1],y)
		area[1][0]=min(area[1][0],x)
		area[1][1]=max(area[1][1],y)

		# start bfs
		self.findMinArea(image,m,n,x-1,y,area)
		self.findMinArea(image,m,n,x+1,y,area)
		self.findMinArea(image,m,n,x,y-1,area)
		self.findMinArea(image,m,n,x,y+1,area)
	"""
	"""
		Binary-search Method:
			Space complexity: O(1)
			Time complexity: O(mlogn+nlogm)
	"""
	def minArea(self, image, x, y):
		
		# :type image: List[List[str]]
		# :type x: int
		# :type y: int
		# :rtype: int
		
		if len(image)==0 or len(image[0])==0: return 0
		m,n=len(image),len(image[0])
		top=self.binary_search(0, x, lambda x: '1' in image[x])
		bottom=self.binary_search(x, m, lambda x: '1' not in image[x])
		left=self.binary_search(0, y, lambda y: any(row[y]=='1' for row in image))
		right=self.binary_search(y, n, lambda y: all(row[y]=='0' for row in image))
		return (bottom-top)*(right-left)

	def binary_search(self, s, e, visited):
		if s<e:
			mid=(e-s)/2+s
			if visited(mid):
				return self.binary_search(s,mid,visited)
			else:
				return self.binary_search(mid+1,e,visited)
		return s

image=[
  ['0','0','1','0'],
  ['0','1','1','1'],
  ['0','1','0','0']
]

x,y=0,2
for s in image:
	print s
s=Solution()
print "Min area:", s.minArea(image,x,y)