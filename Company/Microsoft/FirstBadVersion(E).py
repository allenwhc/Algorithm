import bisect
# @param version, an integer
# @return a bool
goodOrBad=['Bad','Good','Good','Good','Bad','Good','Bad','Good','Good','Good','Bad']
#goodOrBad=['Good','Bad','Good']
def isBadVersion(version):
	return False if goodOrBad[version]=='Good' else True

class Solution(object):
	"""
		Binary search solution
		Time complexity: O(logn), n is total # of versions
		Extra space: O(1)
	"""
	def firstBadVersion(self, n):
		"""
		:type n: int
		:rtype: int
		"""
		if not n: return 0
		s,e=1,n
		while s<e:
			m=(e-s)/2+s
			if isBadVersion(m):
				e=m
			else: s=m+1
		return s
n=10
sol=Solution()
print "First bad version:",sol.firstBadVersion(n)