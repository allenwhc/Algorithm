class TreeNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution(object):
	def __init__(self):
		self.prev=None
	"""
		Reverse DFS solution
		Time complexity: O(n), n is # of nodes in BT
		Extra space: O(logn)/ O(1)
	"""
	def flatten(self, root):
		"""
		:type root: TreeNode
		:rtype: void Do not return anything, modify root in-place instead.
		"""
		if not root: return
		stack=[]
		while root or stack:
			if root.right: stack.append(root.right)
			if root.left:
				root.right=root.left
				root.left=None
			elif stack:
				root.right=stack.pop()
			root=root.right

	def flatten2(self, root):
		if not root: return
		self.flatten2(root.right)
		self.flatten2(root.left)
		root.right=self.prev
		root.left=None
		self.prev=root

	def printTree(self,root):
		self.printHelper(root, "")

	def printHelper(self,root,indent):
		if root is None: return
		self.printHelper(root.right, indent+"   ")
		print indent+str(root.val)
		self.printHelper(root.left, indent+"   ")

root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(5)
root.left.left=TreeNode(3)
root.left.right=TreeNode(4)
root.right.right=TreeNode(6)
sol=Solution()
print "Tree:"
sol.printTree(root)
p=root
print "Flattened tree:"
sol.flatten(p)
sol.printTree(p)
root=TreeNode(1)
root.left=TreeNode(2)
root.right=TreeNode(5)
root.left.left=TreeNode(3)
root.left.right=TreeNode(4)
root.right.right=TreeNode(6)
q=root
print "Flattened tree:"
sol.flatten2(q)
sol.printTree(q)