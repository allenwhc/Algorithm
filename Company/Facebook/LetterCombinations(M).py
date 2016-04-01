class Solution(object):

	def __init__(self):
		self.keys={'0':' ','1':'','2':'abc','3':'def','4':'ghi','5':'jkl','6':'mno','7':'pqrs','8':'tuv','9':'wxyz'}
	
	"""
		Backtracking DFS solution 1
		Time complexity: O(mn), m is length of digits, n is length of keys
		Extra space: O(m)
	"""
	def letterCombinations(self, digits):
		"""
		:type digits: str
		:rtype: List[str]
		"""
		if not digits: return []
		res,combo=[],['']*len(digits)
		self.backtracking(digits,0,res,combo)
		return res

	def backtracking(self,digits,idx,res,combo):
		if idx==len(digits):
			res.append(''.join(combo))
			return
		key_length=len(self.keys[digits[idx]])
		for i in range(key_length):
			combo[idx]=self.keys[digits[idx]][i]
			self.backtracking(digits,idx+1,res,combo)

	"""
		Backtracking DFS solution 2
		Time complexity: O(mn), m is length of digits, n is length of keys
		Extra space: O(1)
	"""		
	def letterCombinations2(self, digits):
		"""
		:type digits: str
		:rtype: List[str]
		"""
		res=[]
		if not digits: return []
		if len(digits)==1: return list(self.keys[digits[0]])
		else:
			letters=self.letterCombinations2(digits[1:])
			for w in self.keys[digits[0]]:
				for l in letters:
					res.append(w+l)
		return res
	
digits='23'
sol=Solution()
print "Combinations of",digits,":",sol.letterCombinations2(digits)