import operator,math
class Solution(object):
	"""
		Stack solution
		Time complexity: O(n)
		Extra space: O(k)
	"""
	def evalRPN(self, tokens):
		# @param tokens: List[str]
		# @return: int
		stack=[]
		for e in tokens:
			stack.append(e if e not in '+-*/' else `int(eval(stack.pop(-2)+e+stack.pop()+'.'))`)
		return int(stack.pop())

tokens=["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
print 'The evaluation of [%s] is: %d'%(','.join(tokens),Solution().evalRPN(tokens))