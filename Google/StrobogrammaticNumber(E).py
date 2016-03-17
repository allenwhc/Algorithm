class Solution(object):
	def isStrobogrammatic(self, num):
		"""
		:type num: str
		:rtype: bool
		"""
		mid=len(num)/2 if len(num)%2==0 else len(num)/2+1
		for i in range(0,mid):
			if num[i]=='0' or num[i]=='1' or num[i]=='8':
				if num[len(num)-1-i] != num[i]: return False
			elif num[i]=='6':
				if num[len(num)-1-i] != '9': return False
			elif num[i]=='9':
				if num[len(num)-1-i] != '6': return False
			else:
				return False
		return True

nums=["1991","808","12","69","10001"]
s=Solution()
for num in nums:
	print num, "is " if s.isStrobogrammatic(num) else " is not", "a strobogrammatic number"