import collections
class TrieNode(object):
	def __init__(self):
		self.leaf=False
		self.inDict=False
		self.children=collections.defaultdict(TrieNode)

class Trie(object):
	def __init__(self):
		self.root=TrieNode()

	def insert(self,s):
		node=self.root
		for w in s:
			node=node.children[w]
		node.leaf=True
		#print s

	def search(self,s):
		node=self.root
		for w in s:
			node=node.children.get(w)
			if not node: return False
		return node.leaf

	def printTrie(self):
		self.printHelper(self.root,0)

	def printTrie(self, root, indent):
		print (root,indent)
		for child in root.children:
			self.printTrie(child,indent+2)	

class Solution(object):
	"""
		Backtracking solution
		Time complexity: O(nk)
		Extra space: O(1)
	"""
	def wordBreak(self, s, wordDict):
		"""
		:type s: str
		:type wordDict: Set[str]
		:rtype: List[str]
		"""
		if not s or not wordDict: return []
		d={len(s):['']}
		def breakDown(i):
			if not d.has_key(i):
				d[i]=[s[i:j]+(tails and ' '+tails) for j in range(i+1,len(s)+1)
						if s[i:j] in wordDict
						for tails in breakDown(j)]
			return d[i]
		return breakDown(0)

	def backtracking(self,root,s,res,idx,words,path,wordDict):
		print idx,len(s),path,root.leaf
		if idx==len(s): 
			res.append(words)
			return
		if root.leaf and path in wordDict:
			print path
			words+=path+' '
			root.leaf=False
		child=root.children.get(s[idx])
		if not child: return
		for i in range(0,len(s)):
			path+=s[i]
			self.backtracking(child,s,res,i+1,words,path,wordDict)
			path=path[:-1]

s='catsanddog'
wordDict = ["cat", "cats", "and", "sand", "dog"]
sol=Solution()
print 'word break:',sol.wordBreak(s,wordDict)
