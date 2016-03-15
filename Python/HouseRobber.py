
class TreeNode(object):
	def __init__(self,x):
		self.val=x
		self.left=None
		self.right=None

class Solution(object):
	def rob(self, root):
		''' :type root: TreeNode  :rtype: int '''
		if root is None:
			return 0
		dp=self.dfs(root)
		return max(dp[0],dp[1])

	def dfs(self, root):
		if root is None:
			return [0]*2
		sum_left=self.dfs(root.left)
		sum_right=self.dfs(root.right)

		sum1=root.val+sum_left[1]+sum_right[1]
		sum2=max(sum_left[0],sum_left[1]) + max(sum_right[0],sum_right[1])
		return [sum1,sum2]

def print_helper(root, indent):
		if root is not None:
			print_helper(root.right, indent + "   ")
			print indent + str(root.val)
			print_helper(root.left, indent + "   ")
	
def print_tree(root):
	print_helper(root, "")

root=TreeNode(3)
root.left=TreeNode(4)
root.right=TreeNode(5)
root.left.left=TreeNode(1)
root.left.right=TreeNode(3)
root.right.right=TreeNode(1)

print_tree(root)
s=Solution()
x=s.rob(root)
print "Max stolen money: " , str(x)