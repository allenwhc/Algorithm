class Solution(object):
	def calculate(self, s):
		"""
		:type s: str
		:rtype: int
		"""
		stack,res,op,prev_op=[],0,True,True
		s=s.strip()
		i=0
		while i<len(s):
			if s[i]==' ':
				i+=1
				continue
			elif s[i]=='+':
				i+=1
				op=True
			elif s[i]=='-':
				i+=1
				op=False
			elif s[i]=='(':
				i+=1
				stack.append(prev_op)
				prev_op=prev_op if op==True else not prev_op
				op=True
			elif s[i]==')':
				prev_op=stack.pop()
				op=True
				i+=1
			else:
				num=0
				while i<len(s) and s[i].isdigit():
					num=num*10+int(s[i])
					i+=1
				res=res+(num if prev_op==op else 0-num)
		return res

#s="1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10"
#s="(1-(4+5+2)+3)-(6+8)"
s="(1)"
sol=Solution()
print s,"=",sol.calculate(s)