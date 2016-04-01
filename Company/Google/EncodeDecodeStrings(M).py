class Codec:
	"""
		Greedy solution
		Time complexity: O(n), n is length of strs
		Space comlexity: O(n)
	"""
	def encode(self, strs):
		"""Encodes a list of strings to a single string.
		
		:type strs: List[str]
		:rtype: str
		"""
		return ''.join(str(len(s))+"|"+s for s in strs)

	def decode(self, s):
		"""Decodes a single string to a list of strings.
		
		:type s: str
		:rtype: List[str]
		"""
		result,i=[],0
		while i<len(s):
			index_vertical_bar=s.find("|",i)
			string_length=int(s[i:index_vertical_bar])
			valid_string=s[(index_vertical_bar+1):(index_vertical_bar+string_length)+1]
			# print "vertical:",index_vertical_bar,"i:",i,"length:",string_length,"valid str:",valid_string
			result.append(valid_string)
			i=index_vertical_bar+string_length+1
		return result
		

# Your Codec object will be instantiated and called as such:
strs=["63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "]
print "Original strings:",strs
codec = Codec()
print "Encoded string:",codec.encode(strs)
print "Decoded strings:",codec.decode(codec.encode(strs))
# codec.decode(codec.encode(strs))