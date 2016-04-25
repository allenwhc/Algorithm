class Solution(object):
	"""
		Brute force solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def summaryRanges(self,nums):
		# @param nums: List[int]
		# @return: List[str]
		def concludeRange(lower,upper):
			return str(lower)+'->'+str(upper) if lower!=upper else str(lower)
		i,res=0,[]
		while i<len(nums):
			lower,gap,j=nums[i],1,i+1
			while j<len(nums) and lower+gap==nums[j]:
				j+=1
				gap+=1
			j-=1
			upper=nums[j]
			res.append(concludeRange(lower,upper))
			i=j+1
		return res
	
	"""
		Hash table solution
		Time complexity:
		Extra space: 
	"""
	def summaryRanges1(self, nums):
		ranges=[(n-i,n) for i,n in enumerate(nums)]
		lower,upper=dict(ranges[::-1]),dict(ranges)
		return [str(n)+('->'+str(upper[d]))*(n<upper[d]) for d,n in sorted(lower.items())]
		

nums=[0,1,2,4,5,7]
print 'range is:',Solution().summaryRanges1(nums)