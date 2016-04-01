import math
class Solution(object):
	def numSquares(self, n):
		"""
		:type n: int
		:rtype: int
		"""
		if n<=1: return n
		squares,i,count=[],1,0
		while i*i<=n:
			squares.append(i*i)
			i+=1
		pending_to_check={n}
		while pending_to_check:
			count+=1
			temp=set()
			for i in pending_to_check:
				for j in squares:
					if i<j: break
					elif i==j: return count
					else: temp.add(i-j)
				pending_to_check=temp
		return count

n=9975
sol=Solution()
print "# of perfect squares in",n,"is:",sol.numSquares(n)