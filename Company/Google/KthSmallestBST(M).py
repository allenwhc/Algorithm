class TreeNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None
		self.left_node_count=0

class Solution(object):
	"""
		Naive inorder traverse solution
		Time complexity: O(n), n is # of nodes in tree
		Extra space: O(n)
	"""
	def kthSmallest1(self, root, k):
		"""
		:type root: TreeNode
		:type k: int
		:rtype: int
		"""
		inorder=[]
		self.inorderTraverse(root,inorder)
		return inorder[k-1]

	def inorderTraverse(self,root,inorder):
		if not root: return
		self.inorderTraverse(root.left,inorder)
		inorder.append(root.val)
		self.inorderTraverse(root.right,inorder)


	"""
		Stack inorder traverse solution
		Time complexity: O(max(k,logn))
		Extra space: O(k)
	"""
	def kthSmallest2(self, root, k):
		"""
		:type root: TreeNode
		:type k: int
		:rtype: int
		"""
		nodes,i,finished,curr,res=[],0,False,root,0
		while i<k and not finished:
			if curr:
				nodes.append(curr)
				curr=curr.left
			else:
				if nodes:
					curr=nodes.pop()
					res=curr.val
					i+=1
					curr=curr.right
				else: finished=True
		return res

	"""
		Insertion/Deletion traverse solution
		Time complexity: O(h), h is height of a balanced BST
		Extra space: O(1)
	"""
	def kthSmallest3(self, root, k):
		"""
		:type root: TreeNode
		:type k: int
		:rtype: int
		"""
		if not root: return 0
		res,p=0,root
		while p:
			if p.left_node_count+1==k:
				return p.val
			elif k>p.left_node_count:
				k-=p.left_node_count+1
				p=p.right
			else: p=p.left
		return 0

root=None
def insert(nums):
	global root
	for n in nums:
		node=TreeNode(n)
		root=construct(root,node)

def construct(root,node):
	p=q=root
	while p:
		q=p
		if node.val<p.val:
			p.left_node_count+=1
			p=p.left
		else: p=p.right
	if not root: root=node
	elif node.val<q.val:
		q.left=node
	else: q.right=node
	#print root
	return root

def printTree():
	global root
	printHelper(root,'')

def printHelper(root, indent):
	if root:
		printHelper(root.right,indent+'   ')
		print indent+str(root.val),",",root.left_node_count
		printHelper(root.left, indent+'   ')

# root=TreeNode(7)
# root.left=TreeNode(3)
# root.right=TreeNode(11)
# root.left.left=TreeNode(1)
# root.left.right=TreeNode(5)
# root.right.left=TreeNode(9)
# root.right.right=TreeNode(13)
insert([7,3,11,1,5,9,13])

printTree()

k=5
sol=Solution()
print k,'th smallest:',sol.kthSmallest3(root,k)