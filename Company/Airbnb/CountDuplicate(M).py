class Node(object):
	def __init__(self,x=0,idx=0):
		self.val=x
		self.index=idx
		self.duplicate=1
		self.left=None
		self.right=None

class Solution(object):
	def __init__(self):
		self.root=None
		
	def containsNearbyAlmostDuplicate(self, nums, k, t):
		root=None
		nums=sorted([(n,i) for i,n in enumerate(nums)], key=lambda x: x[0])
		root=self.buildBST(root,nums,0,len(nums)-1)
		self.printTree(root,'')
			
	def buildBST(self,root,nums,start,end):
		if start>end: return None
		mid=(end-start)/2+start
		root=Node(nums[mid][0], nums[mid][1])
		root.left=self.buildBST(root.left, nums, start, mid-1)
		root.right=self.buildBST(root.right, nums, mid+1, end)
		return root
		
	def printTree(self, root, indent):
		if not root: return
		self.printTree(root.right, indent+"   ")
		print indent+str(root.val),',',str(root.index)
		self.printTree(root.left, indent+"   ")
		
sol=Solution()
nums,k,t=[3,2,1,-3,5,-7,2],4,2
print sol.containsNearbyAlmostDuplicate(nums,k,t)
