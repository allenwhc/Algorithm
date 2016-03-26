class Solution(object):
	"""
		Topological sort solution
		Time complexity:
		Extra space:
	"""
	"""
		Breadth-first solution
		Time complexity: O(nlogk), n is # of words, k is average length of words
		Extra space: O(k)
	"""
	def alienOrder(self, words):
		"""
		:type words: List[str]
		:rtype: str
		"""
		if not len(words): return ''
		order=[]
		for pair in zip(words,words[1:]):
			for x,y in zip(*pair):
				if x!=y:
					order.append(x+y)
					break
		letters=set(''.join(words))
		dictionary=[]
		while order:
			free_letter=letters-set(zip(*order)[1])
			if not free_letter: return ''
			dictionary+=free_letter
			order=filter(free_letter.isdisjoint,order)
			letters-=free_letter
		return ''.join(dictionary+list(letters))
words=[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

sol=Solution()
print "Dictionary:",sol.alienOrder(words)