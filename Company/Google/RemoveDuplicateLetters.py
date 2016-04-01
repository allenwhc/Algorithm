class RemoveDuplicateLetters(object):
	def removeDuplicateLetters(self,s):
		string=""
		stack=[]
		visited=[0]*26
		appeared=[0]*26
		for c in s:
			appeared[ord(c)-ord('a')]+=1

		for c in s:
			i=ord(c)-ord('a')
			appeared[i]-=1
			if visited[i]==0:
				while len(stack)>0 and appeared[ord(stack[-1])-ord('a')]!=0 and c<stack[-1]:
					top=stack.pop()
					visited[ord(top)-ord('a')]=0
				stack.append(c)
				visited[i]=1;
		for i in stack:
			string+=i
		return string

s="bcabc"
rd=RemoveDuplicateLetters()
print rd.removeDuplicateLetters(s)