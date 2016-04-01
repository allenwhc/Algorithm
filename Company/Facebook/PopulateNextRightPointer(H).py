class TreeLinkNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None
		self.next = None

class Solution(object):
	"""
		BFS solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def connect(self, root):
		"""
		:type root: TreeLinkNode
		:rtype: nothing
		"""
		if not root: return
		queue=[root]
		while queue:
			node=queue.pop(0)
			size=len(queue)
			if node.left: queue.append(node.left)
			if node.right: queue.append(node.right)
			
			for i in range(size):
				next_node=queue.pop(0)
				node.next=next_node
				node=node.next
				if node.left: queue.append(node.left)
				if node.right: queue.append(node.right)
			node.next=None

def printTree(root):
	printHelper(root,"")

def printHelper(root, indent):
	if root:
		printHelper(root.right,indent+"   ")
		print indent+str(root.val),"(",str(root.next.val)+")" if root.next else "none)"
		printHelper(root.left,indent+"   ")

root=TreeLinkNode(1)
root.left=TreeLinkNode(2)
# root.right=TreeLinkNode(3)
# root.left.left=TreeLinkNode(4)
# root.left.right=TreeLinkNode(5)
# root.right.right=TreeLinkNode(7)

print "original tree:"
printTree(root)
sol=Solution()
print "modified tree:"
sol.connect(root)
printTree(root)