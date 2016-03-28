class TreeNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

	def inorder(self,root):
		if root is None: return
		self.inorder(root.left)
		print root.val,
		self.inorder(root.right)

	def postorder(self, root):
		if root is None: return
		self.postorder(root.left)
		self.postorder(root.right)
		print root.val,

class Solution(object):
	"""
		Binary search solution
		Time complexity: O(klogn), k is height of BT, n is length of inorder/postorder
		Extra space: O(1)
	"""
	def buildTree(self, inorder, postorder):
		"""
		:type inorder: List[int]
		:type postorder: List[int]
		:rtype: TreeNode
		"""
		m=len(inorder)
		if not m: return None
		return self.binarySearch(inorder,postorder,0,m-1,m-1)

	def binarySearch(self, inorder, postorder, start, end, k):
		"""
		@param  inorder: List[int]
				postorder: List[int]
				root: TreeNode
				start: int
				end: int
				k: int
		@return: TreeNode
		"""
		if start>end: return None
		root=TreeNode(postorder[k])
		if start==end: return root
		i=end
		while i:
			if inorder[i]==root.val: break
			i-=1
		# print "s=",start,"e=",end,"i=",i,"k=",k,"node=",root.val
		root.right=self.binarySearch(inorder,postorder,i+1,end,k-1)
		root.left=self.binarySearch(inorder,postorder,start,i-1,k-end-1+i)
		return root

	def printTree(self,root):
		self.printHelper(root, "")

	def printHelper(self,root,indent):
		if root is None: return
		self.printHelper(root.right, indent+"   ")
		print indent+str(root.val)
		self.printHelper(root.left, indent+"   ")

inorder=[6,4,7,5,8,10]
postorder=[6,4,8,5,10,7]
# root=TreeNode(7)
# root.left=TreeNode(4)
# root.right=TreeNode(10)
# root.left.left=TreeNode(6)
# root.right.left=TreeNode(5)
# root.right.left.right=TreeNode(8)
# root.postorder(root)
sol=Solution()
sol.printTree(sol.buildTree(inorder,postorder))