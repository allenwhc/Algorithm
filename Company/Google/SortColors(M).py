class Solution(object):
	"""
		Counting sort solution
		Time complexity: O(n), n is length of nums
		Extra space: O(k), k is type of different colors
	"""
	def sortColors1(self, nums):
		"""
		:type nums: List[int]
		:rtype: void Do not return anything, modify nums in-place instead.
		"""
		count=[0]*3
		for i in range(len(nums)):
			count[nums[i]]+=1
		i,j=0,0
		while i<3:
			if count[i]:
				nums[j]=i
				j+=1
				count[i]-=1
			else:
				i+=1

	"""
		Two-pointer solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def sortColors2(self, nums):
		"""
		:type nums: List[int]
		:rtype: void Do not return anything, modify nums in-place instead.
		"""
		red,white,blue=0,0,len(nums)-1
		def swap(nums,i,j):
			temp=nums[i]
			nums[i]=nums[j]
			nums[j]=temp
		while white<=blue:
			if not nums[white]:	# if red ball
				swap(nums,red,white)
				red+=1
				white+=1
			elif nums[white]==1:	# if white ball
				white+=1
			else:
				swap(nums,white,blue)	# if blue ball
				blue-=1

sol=Solution()
nums=[2,1,1,1,2,0,0,1,2,2]
print nums
sol.sortColors2(nums)
print nums