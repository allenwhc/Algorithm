from collections import defaultdict
class ValidWordAbbr(object):
	def __init__(self, dictionary):
		# @param dictionary: List[str]
		self.dictionary=defaultdict(list)
		for w in set(dictionary):
			abbr_word=self.abbreviate(w)
			self.dictionary[abbr_word].append(w)
	
	def isUnique(self, word):
		# @param word: str
		# @return: bool
		abbr_word=self.abbreviate(word)
		if (abbr_word not in self.dictionary) or (len(self.dictionary[abbr_word])==1 and not cmp(word,self.dictionary[abbr_word][0])):
			return True
		if len(self.dictionary[abbr_word])>=1: return False
		return True
	
	def abbreviate(self, word):
		# @param word: str
		# @return: str
		if len(word)<=2: return word
		return word[0]+str(len(word[1:-1]))+word[-1]
		
	
dictionary=['cake','deer','door','card','hello','a','a']
words=['dear','cart','cane','make','hello','a']
v=ValidWordAbbr(dictionary)
for word in words:
	print word,'is' if v.isUnique(word) else 'is not','unique'