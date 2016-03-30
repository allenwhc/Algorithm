class Solution(object):
	def simplifyPath(self, path):
		"""
		:type path: str
		:rtype: str
		"""
		if not len(path): return ''
		res,stack,n,i="",[],len(path),0
		#print i
		while i<n:
			if i<n and path[i]=='/':
				i+=1
				continue
			next_slash_idx=path.find("/",i) if path.find("/",i)!=-1 else n
			s=path[i:next_slash_idx]
			if s=="..":
				if len(stack): stack.pop()
			elif s!='.':
				stack.append(s)
			i=next_slash_idx
		return '/'+'/'.join(stack)
#path="///"

#path="/..hidden"
path="/.././GVzvE/./xBjU///../..///././//////T/../../.././zu/q/e"
print path
sol=Solution()
print "simplified path:",sol.simplifyPath(path)