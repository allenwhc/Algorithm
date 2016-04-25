class Solution(object):
	"""
		Intersection solution
		Time complexity: O(n)
		Extra space: O(n)
	"""
	def shortestPalindrome(self, s):
		# @param s: str
		# @return: str
		t=s[::-1]
		for i in range(len(s)+1):
			if s.startswith(t[i:]): return t[:i]+s

s='aabc'
print 'shortest palindrome of %s is: %s'%(s,Solution().shortestPalindrome(s))
		