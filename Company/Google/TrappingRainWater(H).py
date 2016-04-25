class Solution(object):
	"""
		One-pass two pointer solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def trap(self, height):
		# @param height: List[int]
		# @return: int
		if len(height)<=1: return 0
		l,r,res=0,len(height)-1,0
		area,block,restriction=0,0,0
		while l<=r:
			if min(height[l],height[r])>restriction:
				area+=(min(height[l],height[r])-restriction)*(r-l+1)
				restriction=min(height[l],height[r])
			if height[l]<height[r]:
				block+=height[l]
				l+=1
			else:
				block+=height[r]
				r-=1
		return area-block

height=[0,1,0,2,1,0,1,3,2,1,2,1]
print "Max trapped water:%d"%Solution().trap(height)