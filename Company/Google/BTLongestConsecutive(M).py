class TreeNode(object):
	def __init__(self, x):
		self.val=x
		self.left=None
		self.right=None

class Solution(object):
	def longestConsecutive(self, root):
		# @param root: TreeNode
		# @return: int
		if not root: return 0
		res=[0]
		def dfs(root, target, count, res):
			# @param root: TreeNode
			# @param target: int 
			# @return: None
			if not root: return
			if root.val==target: count+=1
			else: count=1
			res[0]=max(res[0],count)
			dfs(root.left, root.val+1, count, res)
			dfs(root.right, root.val+1, count, res)
		dfs(root,root.val,0,res)
		return res[0]

root=TreeNode(1)
root.right=TreeNode(3)
root.right.left=TreeNode(2)
root.right.right=TreeNode(4)
root.right.right.right=TreeNode(5)
	
def printTree(root, indent):
	#@param root: TreeNode
	#@param indent: str
	#@return: None
	if not root: return
	printTree(root.right,indent+'   ')
	print indent+str(root.val)
	printTree(root.left, indent+'   ')

printTree(root,'')
print 'Length of longest consecutive is: %s'%Solution().longestConsecutive(root)
