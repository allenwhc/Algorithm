import collections
class TrieNode(object):
	"""docstring for TrieNode"""
	def __init__(self):
		#self.label=c
		self.leaf=False
		self.children=collections.defaultdict(TrieNode)

class Trie(object):
	def __init__(self):
		self.root=TrieNode()

	def insert(self, word):
		node=self.root
		for c in word:
			node=node.children[c]
		node.leaf=True

	def search(self, word):
		node=self.root
		for c in word:
			node=node.children.get(c)
			if not node: return False
		return node.leaf

class Solution(object):
	"""
		Check if a word is in board
		Backtracking/DFS solution
		Time complexity: O(mn*(m+n)), m*n is size of board
		Extra space: O(1)
	"""
	def exist(self, board, word):
		"""
		:type board: List[List[str]]
		:type word: str
		:rtype: bool
		"""
		if not len(board) or not len(board[0]): return False
		m,n,res=len(board),len(board[0]),False
		for i in range(m):
			for j in range(n):
				if self.wrapper(board,word,i,j): return True
		return False

	def wrapper(self,board,word,i,j):
		if board[i][j]==word[0]:
			if not word[1:]: return True
			board[i][j]='*'
			if i>0 and self.wrapper(board,word[1:],i-1,j): return True
			if i<len(board)-1 and self.wrapper(board,word[1:],i+1,j): return True
			if j>0 and self.wrapper(board,word[1:],i,j-1): return True
			if j<len(board[0])-1 and self.wrapper(board,word[1:],i,j+1): return True
			board[i][j]=word[0]
			return False
		return False

	"""
		Find words in list that exist in board
		Backtracking/Trie solution
		Time complexity: O(mnh) m*n is size of board, h is average height of Trie
		Extra space: O(k), k is total # of letters in words
	"""
	def findWords(self, board, words):
		"""
		:type board: List[List[str]]
		:type words: List[str]
		:rtype: List[str]
		"""
		if not words or not board: return []
		if len(board)==len(board[0])==1: return board[0] if words.count(board[0][0]) else []
		t,res=Trie(),[]
		root=t.root
		for word in words:
			t.insert(word)
		for i in xrange(len(board)):
			for j in xrange(len(board[0])):
				self.dfs(board,i,j,root,res,'')
		return res

	def dfs(self,board,i,j,node,res,path):
		# @param board: List[List[str]]
		# @param i,j: int
		# @param node: Trie
		# @rType: void
		if node.leaf:
			res.append(path)
			node.leaf=False
		c=board[i][j]
		if not node.children.get(c): 
			return
		# print node.children.get(c).leaf
		board[i][j]='*'
		if i>0: self.dfs(board,i-1,j,node.children.get(c),res,path+c)
		if i<len(board)-1: self.dfs(board,i+1,j,node.children.get(c),res,path+c)
		if j>0: self.dfs(board,i,j-1,node.children.get(c),res,path+c)
		if j<len(board[0])-1: self.dfs(board,i,j+1,node.children.get(c),res,path+c)
		board[i][j]=c

board=[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

word="oath"
words=['a']
sol=Solution()
print word,"is" if sol.exist(board,word) else "isn't","in board"
board=[
	['a']
]
print sol.findWords(board,words),"in",words,"are in board"