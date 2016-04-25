class Solution(object):
	"""
		Two pointer solution
		Time complexity: O(n), n is length of string
		Extra space: O(k), k is # of vowels in upper/lower case
	"""
	def reverseVowels(self, s):
		# @param s: str
		# @return: str
		i,j=0,len(s)-1
		vowels=['A','a','E','e','I','i','O','o','U','u']
		s=list(s)
		while i<j:
			if s[i] not in vowels or s[j] not in vowels:
				i+=1 if s[i] not in vowels else 0
				j-=1 if s[j] not in vowels else 0
			else:
				tmp=s[i]
				s[i]=s[j]
				s[j]=tmp
				i+=1
				j-=1
		return ''.join(s)
		
s='leetcode'
print '%s after reverse vowels is: %s'%(s,Solution().reverseVowels(s))