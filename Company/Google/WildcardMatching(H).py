class Solution(object):
	def isMatch(self, s, p):
		"""
		:type s: str
		:type p: str
		:rtype: bool
		"""
		i,j,star_pos_in_p,star_pos_char_in_s=0,0,-1,-1
		while i<len(s):
			if j<len(p) and (s[i]==p[j] or p[j]=='?'):
				i+=1
				j+=1
			elif j<len(p) and p[j]=='*':
				star_pos_in_p=j
				star_pos_char_in_s=i
				j+=1
			elif star_pos_in_p!=-1:
				j=star_pos_in_p+1
				star_pos_char_in_s+=1
				i=star_pos_char_in_s
			else:
				return False
				
		while j<len(p) and p[j]=='*': j+=1
		return j==len(p)

s="ab"
p="*a"
sol=Solution()
print p,"matches" if sol.isMatch(s,p) else "doesn't match", s