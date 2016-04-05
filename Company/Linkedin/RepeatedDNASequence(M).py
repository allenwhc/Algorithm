class Solution(object):
	"""
		Hash table solution
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def findRepeatedDnaSequences(self, s):
		"""
		:type s: str
		:rtype: List[str]
		"""
		res,d=set(),set()
		for i in range(len(s)-9):
			dna_sequence=s[i:i+10]
			#print dna_sequence
			if dna_sequence in d:
				res.add(dna_sequence)
			else: d.add(dna_sequence)
		return list(res)
s="AAAAAAAAAAAA"
sol=Solution()
print 'Repeated DNA sequences:',sol.findRepeatedDnaSequences(s)