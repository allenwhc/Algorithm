"""
	Binary search tree solution
	Time complexity:
	Extra space: 
"""
class TreeNode(object):
	def __init__(self,x):
		self.val=x
		self.left=None
		self.right=None
		self.duplicate=1
		self.left_node_count=0
		self.right_node_count=0

	def insert(self,node,x):
		if not node: 
			node=TreeNode()
			node.val=x
		elif node.val==x: node.duplicate+=1
		elif node.val>x:
			node.left_node_count+=1
			node.left=self.insert(node.left,x)
		else:
			node.right_node_count+=1
			node.right=self.insert(node.right,x)

	def printTree(self,root,indent):
		if root:
			self.printTree(root.right,indent+'   ')
			print indent+str(root.val)
			self.printTree(root.left, indent+'   ')

class Tree(object):
	"""docstring for Tree"""
	def __init__(self, arg):
		super(Tree, self).__init__()
		self.root=TreeNode()
		

class Solution(object):
	"""
		Divide-and-conquer solution
		Time complexity: O(nlogn), n is length of nums
		Extra space:
	"""
	def countRangeSum(self, nums, lower, upper):
		"""
		:type nums: List[int]
		:type lower: int
		:type upper: int
		:rtype: int
		"""
		sums=[0]
		for n in nums:
			sums.append(sums[-1]+n)
		return self.sort(sums,0,len(sums))

	def sort(self,sums,s,e):
		mid=(e-s)/2+s
		if s==mid: return 0
		count=self.sort(sums,s,mid)+self.sort(sums,mid,e)

		i=j=mid
		for l in sums[s:mid]:
			while i<e and sums[i]-l<lower: i+=1
			while j<e and sums[j]-l<=upper: j+=1
			count+=j-i
		sums[s:e]=sorted(sums[s:e])
		return count

nums=[-2,5,-1]
lower,upper=-2,2
sol=Solution()
print "# of ranges:",sol.countRangeSum(nums,lower,upper)