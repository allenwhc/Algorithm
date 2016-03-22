class Solution(object):
	def numWays(self, n, k):
		"""
		:type n: int
		:type k: int
		:rtype: int
		"""
		if n<2 or k==0: return n*k
		same_color_previous=0
		different_color_previous=k
		total=same_color_previous+different_color_previous
		for i in range(1,n):
			same_color_previous=different_color_previous
			different_color_previous=(k-1)*total
			total=same_color_previous+different_color_previous

		return total
n=4
k=4
sol=Solution()
print sol.numWays(n,k),"ways to paint",n,"posts with",k,"different colors with no more than two adjacent posts has the same color."