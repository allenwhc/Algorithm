class Solution(object):
	def wordBreak(self,s,wordDict):
		# @param s: str
		# @param wordDict: Set[str]
		# @return: bool
		return True

s='leetcode'
wordDict=set(['leet','code'])
print '%s'%s,'can' if Solution().wordBreak(s,wordDict) else 'cannot','be found'