class Solution(object):
	def hammingWeight(self,n):
		# @param n: int
		# @return: int
		return bin(n if n>0 else n & 0xFFFFFFFF)[2:].count('1')
		#return list('{0:b}'.format(n if n>0 else n & 0xFFFFFFFF)).count('1')
n=-100
print 'Hamming weight of %d is: %d'%(n,Solution().hammingWeight(n))