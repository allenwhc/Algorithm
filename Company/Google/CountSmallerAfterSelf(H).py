from operator import itemgetter

class Node(object):
	def __init__(self, x=0, size=0):
		self.val=x
		self.left_size=size
		self.duplicate=1
		self.left=None
		self.right=None
		
class Solution(object):
	"""
		Binary search tree solution
		Time complexity: O(nlogn)
		Extra space: O(n)
	"""	
	def countSmaller(self, nums):
		root,node_count=None,[0 for i in xrange(len(nums))]
		for i in xrange(len(nums)-1, -1, -1):
			root=self.insert(root,nums[i],i,node_count,0)
		return node_count
	
	def insert(self, root, val, index, node_count, left_node_num):
		if not root: 
			root=Node(val, 0)
			node_count[index]=left_node_num
		elif root.val<val:
			root.right=self.insert(root.right,val,index,node_count,left_node_num+root.duplicate+root.left_size)
		elif root.val==val:
			root.duplicate+=1
			node_count[index]=left_node_num+root.left_size
		else:
			root.left_size+=1
			root.left=self.insert(root.left,val,index,node_count,left_node_num)
		return root
	
	"""
		Fenwick tree solution
		Time complexity: O(nlogn)
		Extra space: O(n)
	"""
	def countSmaller1(self, nums):
		index_tree,count=[0 for i in xrange(len(nums)+1)],[0 for i in xrange(len(nums))]
		nums=sorted([(n,i) for i, n in enumerate(nums)],key=lambda x: x[0])
		for i, (x,index) in enumerate(nums):
			count[index]=i-self.get(index_tree,index+1)
			self.update(index_tree,index+1,len(nums),1)
		return count
	
	def	get(self,index_tree, index):
		sum=0
		while index>0:
			sum+=index_tree[index]
			index-=index & -index
		return sum
	
	def update(self, index_tree, index, n, val):
		while index<=n:
			index_tree[index]+=val
			index+=index & -index

sol=Solution()
nums=[5,2,6,1]
smaller=sol.countSmaller1(nums)
for i,n in enumerate(nums):
	print "# smaller than %d on the right in %s is %d."%(n,','.join([str(x) for x in nums]),smaller[i])