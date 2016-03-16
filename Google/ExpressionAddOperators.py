class Solution(object):
	def addOperators(self, num, target):
		"""
		:type num: str
		:type target: int
		:rtype: List[str]
		"""
		result=[]
		for i in range(1, len(num)+1):
			curr_str=num[0:i]
			curr_num=long(curr_str)
			if len(curr_str)!=len(str(curr_num)):
				continue
			else:
				self.wrapper(num,target,result,curr_str,'#',curr_num,curr_num,i)
		return result

	def wrapper(self,num,target,result,s,operator,prev,curr,i):
		if i==len(num) and curr==target:
			result.append(s)

		for j in range(i+1,len(num)+1):
			curr_str=s[i-1:j-1]
			print curr_str
			curr_num=long(curr_str)
			if len(curr_str)!=len(str(curr_num)):
				continue
			else:
				self.wrapper(num,target,result,s+'+'+curr_str,'+',curr_num,curr_num+curr,j)
				self.wrapper(num,target,result,s+'-'+curr_str,'-',curr_num,curr-curr_num,j)
				self.wrapper(num,target,result,s+'*'+curr_str,operator,prev*curr_num,curr+prev-prev*curr_num if operator=='-' else (curr-prev+prev*curr_num if operator=='+' else prev*curr_num),j)


num=["123","232","105","00","3456237490"]
target=[6,8,5,0,9191]

s=Solution()
for i in range(0, len(num)):
	print num[i], "->", target[i], ":", s.addOperators(num[i],target[i])