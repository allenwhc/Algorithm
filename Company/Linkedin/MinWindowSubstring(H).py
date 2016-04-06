import itertools,collections
class Solution(object):
	"""
		Hash table/Two pointer solution
		Time complexity: O(m), m is length of s
		Extra space: O(n), n is length of t
	"""
	def minWindow(self, s, t):
		"""
		:type s: str
		:type t: str
		:rtype: str
		"""
		if not s or not t or len(s)<len(t): return ''
		d,count=collections.Counter(t),len(t)
		l,r,L,R=0,0,0,len(s)+1
		for r,c in enumerate(s,start=1):
			count-=d[c]>0
			d[c]-=1
			if not count:
				while l<r and d[s[l]]<0:
					d[s[l]]+=1
					l+=1
				if not R or r-l<=R-L:
					L,R=l,r
		return s[L:R]

s='cabwefgewcwaefgcf'

t='caec'
sol=Solution()
print 'min substring:',sol.minWindow(s,t)