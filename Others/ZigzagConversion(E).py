import itertools
class Solution(object):
	"""
		Time complexity: O(n)
		Extra space: O(numRows)
	"""
	def convert(self,s,numRows):
		# @param s: str
		# @param numRows: int
		# @return: str
		n,res,lv,idx=len(s),['']*(numRows+1),1,1
		for c in s:
			res[lv*idx]+=c
			lv+=1
			if lv>=numRows: 
				lv,idx=1,-idx
		return ''.join(res)

s='PAYPALISHIRING'
numRows=3
print 'Zigzag conversion for %s is: %s'%(s,Solution().convert(s,numRows))