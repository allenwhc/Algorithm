class Solution(object):
	def isValid(self, s):
		"""
		:type s: str
		:rtype: bool
		"""
		if len(s)==0:
			return False
		stack=[]
		for c in s:
			if len(stack)==0 or c == '(' or c=='[' or c=='{':
				stack.append(c)
			elif c==')':
				if(stack.pop()!='('):
					return False
			elif c==']':
				if(stack.pop()!='['):
					return False
			elif c=='}':
				if(stack.pop()!='{'):
					return False
			else:
				return False
		return len(stack)==0

s="["
print s
sol=Solution()
print sol.isValid(s)