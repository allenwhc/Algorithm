class Solution(object):
	"""
		DFS solution
		Time complexity: O(n^2), n is length of s
		Extra space: O(n)
	"""
	def removeInvalidParentheses(self, s):
		"""
		:type s: str
		:rtype: List[str]
		"""
		res,l,r=set(),0,0
		for c in s:
			if c=='(': l+=1
			elif c==')':
				if l: l-=1
				else: r+=1
		self.dfs(s,'',l,r,0,0,res)
		return list(res)

	def dfs(self,s,path,l,r,idx,noPairs,res):
		if idx==len(s):
			if not l and not r and not noPairs:
				res.add(path)
			return
		if s[idx]!='(' and s[idx]!=')':
			self.dfs(s,path+s[idx],l,r,idx+1,noPairs,res)
		else:
			if s[idx]=='(':
				if l: self.dfs(s,path,l-1,r,idx+1,noPairs,res)
				self.dfs(s,path+s[idx],l,r,idx+1,noPairs+1,res)
			else:
				if r: self.dfs(s,path,l,r-1,idx+1,noPairs,res)
				if noPairs: self.dfs(s,path+s[idx],l,r,idx+1,noPairs-1,res)

s='('
sol=Solution()
print 'valid form of',s,'is:',sol.removeInvalidParentheses(s)