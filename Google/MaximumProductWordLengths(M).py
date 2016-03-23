import itertools
class Solution(object):
	"""
		Brute force bit-manipulation Solution
		Time complexity: O(n^2), n is length of List[str]
		Space complexity: O(n)
	"""
	# def maxProduct(self, words):
	# 	"""
	# 	:type words: List[str]
	# 	:rtype: int
	# 	"""
	# 	n=len(words)
	# 	if not n: return 0
	# 	bit_arr=[0 for _ in range(n)]
	# 	max_product=0

	# 	for i in range(n):
	# 		for c in words[i]:
	# 			bit_arr[i] |= 1<<(ord(c)-ord('a'))
	# 		if i>0:
	# 			for j in range(i-1,-1,-1):
	# 				if not (bit_arr[i] & bit_arr[j]):
	# 					max_product=max(max_product,len(words[i])*len(words[j]))
	# 	return max_product

	"""
		Bitmap Solution
		Time complexity: O(mn), m is average length of strs, n is length of List[str]
		Space complexity: O(n)
	"""
	def maxProduct(self, words):
		"""
		:type words: List[str]
		:rtype: int
		"""
		bit_map={sum(1<<(ord(c)-ord('a')) for c in set(w)): len(w) for w in sorted(words,key=len)}
		return max([bit_map[i]*bit_map[j] for i, j in itertools.combinations(bit_map.keys(),2) if not i&j] or [0])

		
words=["abcw","baz","foo","bar","xtfn","abcdef"]
sol=Solution()
print "Max product:",sol.maxProduct(words)