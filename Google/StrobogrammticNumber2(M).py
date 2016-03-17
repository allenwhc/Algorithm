class Solution(object):
	def findStrobogrammatic(self, n):
		"""
		:type n: int
		:rtype: List[str]
		"""
		res=[]
		s=[]
		for i in range(0,n):
			s.append(' ')
		self.wrapper(res,0,n-1,s)
		return res

	def wrapper(self, res, l, r, s):
		if l>r:
			res.append(''.join(s))
			return
		elif l==r:
			s[l]='0'
			self.wrapper(res,l+1,r-1,s)
			s[l]='1'
			self.wrapper(res,l+1,r-1,s)
			s[l]='8'
			self.wrapper(res,l+1,r-1,s)
		else:
			if l!=0:
				s[l]=s[r]='0'
				self.wrapper(res,l+1,r-1,s)

			s[l]='1'
			s[r]='1'
			self.wrapper(res,l+1,r-1,s)
			s[l]='6'
			s[r]='9'
			self.wrapper(res,l+1,r-1,s)
			s[l]='8'
			s[r]='8'
			self.wrapper(res,l+1,r-1,s)
			s[l]='9'
			s[r]='6'
			self.wrapper(res,l+1,r-1,s)

n=2
s=Solution()
print "All stobogrammatic numbers with ",n," digits are: ",s.findStrobogrammatic(n)