class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        wordDict={}
        for c in s:
            if c in wordDict:
                wordDict[c]+=1
            else:
                wordDict[c]=1
        odd=0
        even=0
        for v in wordDict.values():
            if v%2 != 0:
                odd+=1
            else:
                even+=1
        if odd > 1:
            return False
        else:
            return True

s="aab"
so=Solution()
print "%s"%s,":" , so.canPermutePalindrome(s)
