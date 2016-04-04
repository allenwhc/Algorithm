import collections
class Solution(object):
	"""
		Hash table solution
		Time complexity: O(n), n is length of s
		Extra space: O(k), k is # of distinct letters
	"""
	def lengthOfLongestSubstringKDistinct(self, s, k):
		"""
		:type s: str
		:type k: int
		:rtype: int
		"""
		if not s or not k: return 0
		res,d,distinct,j=0,collections.defaultdict(int),0,-1
		for i in xrange(len(s)):
			d[s[i]]+=1
			while len(d)>k:
				j+=1
				d[s[j]]-=1
				if d[s[j]]==0:
					d.pop(s[j])
			res=max(res,i-j)
		return res

	"""
		Sliding window solution
		Time complexity: O(n)
		Extra space: O(n)
	"""
	def lengthOfLongestSubstringKDistinct2(self, s, k):
		"""
		:type s: str
		:type k: int
		:rtype: int
		"""
		if not s or not k: return 0
		l,res,distinct,d=0,0,0,[0]*128
		for r, c in enumerate(s):
			if not d[ord(c)]: distinct+=1
			d[ord(c)]+=1
			while distinct>k:
				if d[ord(s[l])]==1: distinct-=1
				d[ord(s[l])]-=1
				l+=1
			res=max(res,r-l+1)
		return res

s="eccdceeba"
k=2
sol=Solution()
print "length of substring with",k,"distinct letters:",sol.lengthOfLongestSubstringKDistinct(s,k)