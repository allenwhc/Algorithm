import sys
class Solution(object):
	"""
		Two-end BFS solution
		Time complexity: O(26^(n/2)*m*n), n is size of wordlist, m is length of each word
		Extra space: O(n)
	"""
	def ladderLength(self, beginWord, endWord, wordList):
		"""
		:type beginWord: str
		:type endWord: str
		:type wordList: Set[str]
		:rtype: int
		"""
		ladder1,ladder2,wordMap=set([beginWord]),set([endWord]),{}
		# wordList.add(endWord)
		length=[sys.maxint]*1
		self.bfs(wordList,ladder1,ladder2,wordMap,False)
		#print wordMap
		self.backtracking(wordMap,beginWord,endWord,length,0)
		return 0 if length[0]==sys.maxint else length[0]+1

	def bfs(self,wordList,ladder1,ladder2,wordMap,backward):
		if not ladder1: return False
		if len(ladder1)>len(ladder2): 
			return self.bfs(wordList,ladder2,ladder1,wordMap,not backward)
		wordList-=ladder1
		wordList-=ladder2
		isFinished,new_set=False,set()
		for word in ladder1:
			for i in range(len(word)):
				ch=list(word)
				for c in range(97,123):
					ch[i]=chr(c)
					new_word=''.join(ch)
					key,value,l=word if not backward else new_word, word if backward else new_word,[]

					if key in wordMap:
						l=wordMap[key]

					if new_word in ladder2:
						isFinished=True
						l.append(value)
						wordMap[key]=l

					if not isFinished and new_word in wordList:
						#print new_word
						new_set.add(new_word)
						l.append(value)
						wordMap[key]=l
		return isFinished or self.bfs(wordList,ladder2,new_set,wordMap,not backward)

	def backtracking(self,wordMap,beginWord,endWord,min_length,count):
		#print beginWord
		if beginWord==endWord:
			#print count
			min_length[0]=min(min_length[0],count)
			return
		if beginWord not in wordMap: 
			return
		for word in wordMap[beginWord]:
			self.backtracking(wordMap,word,endWord,min_length,count+1)

beginWord="a"
endWord="c"
wordList=set(["a,b,c"])
#wordList=set(["hot","dot","dog","lot","log"])
sol=Solution()
print sol.ladderLength(beginWord,endWord,wordList)
