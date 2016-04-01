class Solution(object):

	def numberToWords(self, num):
		"""
		:type num: int
		:rtype: str
		"""
		oneToNineteen='One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
		tens='Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()
		def toWords(n):
			if n<20:	# for numbers from 1-19
				return oneToNineteen[n-1:n]
			elif n<100:		# for numbers from 20-99
				return [tens[n/10-2]]+toWords(n%10)
			elif n<1000:	# for numbers from 100-999
				return [oneToNineteen[n/100-1]]+['Hundred']+toWords(n%100)
			else:
				for x,w in enumerate(('Thousand','Million','Billion'),start=1):
					print x,w
					if n<1000**(x+1):
						return toWords(n/1000**x)+[w]+toWords(n%1000**x)
		return ' '.join(toWords(num)) or 'Zero'

num=2147483647
sol=Solution()
print num,"is:",sol.numberToWords(num)
