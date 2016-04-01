class Solution(object):
	"""
		Stack solution
		Time complexity: O(n), n is n # of nodes in BT
		Extra space: O(1)
	"""
	def isValidSerialization(self, preorder):
		"""
		:type preorder: str
		:rtype: bool
		"""
		nodes,i,stack_depth=preorder.split(","),0,0
		while i<len(nodes)-1:
			if nodes[i]=='#':
				if not stack_depth: return False
				stack_depth-=1	# if not empty, pop top of stack
			else: stack_depth+=1 # push to stack
			i+=1
		return nodes[i]=='#' and stack_depth==0
		
preorder="1,#,#"
sol=Solution()
print preorder,"is" if sol.isValidSerialization(preorder) else "is not","a valid preorder traverse"
