class Solution(object):
	"""
		Greedy solution
		Time complexity: O(mn)
		Extra space: O(n)
	"""
	def multiply(self, num1, num2):
		# @param num1: str
		# @param num2: str
		# @return: str
		m,n,res,carry=len(num1),len(num2),'',0
		if not m or not n: return res
		num1,num2=num1[::-1],num2[::-1]
		multiply_str=[0 for i in xrange(m+n)]
		for i in xrange(m):
			for j in xrange(n):
				multiply_str[i+j]+=int(num1[i])*int(num2[j])
		for i,n in enumerate(multiply_str):
			carry,digit=n/10,n%10
			res+=str(digit)
			if i<len(multiply_str)-1: multiply_str[i+1]+=carry
		while len(res)>1 and not int(res[-1]): res=res[:-1]
		return res[::-1]


num1='0'
num2='0'
print '%s * %s = %s'%(num1,num2,Solution().multiply(num1,num2))