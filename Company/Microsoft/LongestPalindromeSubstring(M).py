class Solution(object):
	"""
		Two pointer solution
		Time complexity: O(nm)
		Extra space: O(1)
	"""
	def longestPalindrome(self, s):
		# @param s: str
		# @return: str
		l,r,res,roc=0,len(s)-1,'',0
		def isPalindrome(s,i,j):
			if i<0 or j>=len(s): return False
			while i<j:
				if s[i]!=s[j]: return False
				i+=1
				j-=1
			return True
		for i in xrange(len(s)):
			if isPalindrome(s,i-roc,i):
				l,r=i-roc,i
				roc+=1
			elif isPalindrome(s,i-roc-1,i):
				l,r=i-roc-1,i
				roc+=2
		return s[l:r+1]
	
	"""
		Knuth-Morris-Pratt (KMP) solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def longestPalindrome1(self,s):
		return s

s='aaconfsvodsaasdasgbo'
print 'longest palindrome in %s is: %s'%(s,Solution().longestPalindrome1(s))
		