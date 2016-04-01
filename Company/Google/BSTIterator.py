class TreeNode(object):
	def __init__(self,x):
		self.val=x
		self.left=None
		self.right=None

class BSTIterator:
	stack=[]
	def __init__(self, root):
		"""
		:type root: TreeNode
		"""
		p=root
		while p is not None:
			self.stack.append(p)
			p=p.left

	def hasNext(self):
		"""
		:rtype: bool
		"""
		return True if len(self.stack)!=0 else False

	def next(self):
		"""
		:rtype: int
		"""
		if len(self.stack)==0: return 0
		node=self.stack.pop()
		res=node.val
		node=node.right
		while node is not None:
			self.stack.append(node)
			node=node.left
		return res

root=None
def insert(x):
	"""
		type: x -- int
		rType: void
	"""
	global root
	root=create_node(root,x)

def create_node(root,x):
	if root is None:
		return TreeNode(x)
	if x<=root.val:
		root.left=create_node(root.left,x)
	else:
		root.right=create_node(root.right,x)
	return root

def print_tree():
	global root
	print_helper(root, "")

def print_helper(root, indent):
	if root is not None:
		print_helper(root.right, indent+"   ")
		print indent+str(root.val)
		print_helper(root.left, indent+"   ")


insert(7)
insert(3)
insert(11)
insert(13)
insert(1)
insert(5)
insert(9)
print_tree()

it,v=BSTIterator(root),[]
while(it.hasNext()):
	v.append(it.next())
print v

