class Solution(object):
	"""
		Loop solution
		Time complexity: O(4^k)
		Extra space: O(1)
	"""
	def isPowerOfFour(self, num):
		if num<=0: return False
		n=num
		while n>1:
			if n%4: return False
			n/=4
		return True

	"""
		Bit manipulation solution
		Time complexity: O(1)
		Extra space: O(1)
	"""
	def isPowerOfFour2(self, num):
		return (num!=0 and not (num&(num-1)) and (num&0x55555555)!=0)


nums=[16,5,24,32,36,47]
for num in nums:
	print "%d"%num,'is' if Solution().isPowerOfFour2(num) else 'is not','power of four'