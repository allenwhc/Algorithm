class Solution(object):
    def palindromePairs(self, words):
        """
        :type words: List[str]
        :rtype: List[List[int]]
        """
        wordDict={}
        res=[]
        for i in range(0, len(words)):
        	wordDict[words[i]]=i
        for i in range(len(words)):
        	for j in range(len(words[i])+1):
        		tmp1=words[i][:j]
        		tmp2=words[i][j:]
        		""" If the reverse of current word is in the list """
        		if tmp1[::-1] in wordDict and wordDict[tmp1[::-1]]!=i and tmp2[::-1]==tmp2:
        			res.append([i,wordDict[tmp1[::-1]]])
        		""" If not """
        		if j!=0 and tmp2[::-1] in wordDict and wordDict[tmp2[::-1]]!=i and tmp1[::-1]==tmp1:
        			res.append([wordDict[tmp2[::-1]],i])
        return res

words=["abcd","dcba","lls","s","sssll"]
print words
s=Solution()
print ( s.palindromePairs(words))