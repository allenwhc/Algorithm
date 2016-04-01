import sys
class TreeNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution(object):
	"""
		Stack solution
		Time complexity: O(klogn), n is # of nodes in BST, k is # of closest values
		Space complexity: O(klogn)
	"""
		
	def closestKValues(self, root, target, k):
		"""
		:type root: TreeNode
		:type target: float
		:type k: int
		:rtype: List[int]
		"""
		if not root: return []
		predecessor,successor=[],[]
		self.inorder(root,target,False,predecessor)
		self.inorder(root,target,True,successor)
		# print predecessor,successor
		result=[]
		while k:
			diff1=target-float(predecessor[-1]) if predecessor else sys.maxint
			diff2=float(successor[-1])-target if successor else sys.maxint
			result.append(predecessor.pop() if diff1<diff2 else successor.pop())
			k-=1
		return sorted(result)

	def inorder(self,root,target,flag,stack):
		"""
		:type root: TreeNode
		:type target: float
		:type flag: bool
		:type stack: List[int]
		"rType: None (void)
		"""
		if not root: return
		self.inorder(root.left if not flag else root.right, target, flag, stack)
		if (not flag and root.val>target) or (flag and root.val<=target): return	# find cross-value node
		stack.append(root.val)
		self.inorder(root.right if not flag else root.left, target, flag, stack)


root=None
arr=[1,2,3,4]
#arr=[-13,-10,-4,-1,0,1,2,4,7,12,15]
def constructBST():
	global root, arr
	root=dfs(arr,0,len(arr)-1)

def dfs(arr, s, e):
	if s>e: return None
	mid=(e-s)/2+s
	root=TreeNode(arr[mid])
	root.left=dfs(arr,s,mid-1)
	root.right=dfs(arr,mid+1,e)
	return root

def print_tree():
	global root
	print_helper(root, "")

def print_helper(root, indent):
	if root is not None:
		print_helper(root.right, indent+"   ")
		print indent+str(root.val)
		print_helper(root.left, indent+"   ")

constructBST()
print_tree()
sol=Solution()
k,target=1,2.0
print "Closest",k,"values to",target,"are:",sol.closestKValues(root,target,k)

		