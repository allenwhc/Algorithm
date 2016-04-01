class Solution(object):
	"""
		String reverse solution
		Time complexity: O(nk), n is length of s, k is average length of each word
		Extra space: O(1)
	"""
	def reverseWords(self, s):
		"""
		:type s: a list of 1 length strings (List[str])
		:rtype: nothing
		"""
		if not len(s): return
		s.reverse()
		start,n=0,len(s)

		def reverseS(s,start,end):
			if 0<=start<end<len(s):
				c=s[start]
				s[start]=s[end]
				s[end]=c
				reverseS(s,start+1,end-1)

		for i in range(n):
			if i==n-1:
				reverseS(s,start,i)
			if s[i]==' ':
				reverseS(s,start,i-1)
				start=i+1

s=['h','e','l','l','o',' ','w','o','r','l','d']
print s
sol=Solution()
sol.reverseWords(s)
print s
