class Solution(object):
	# def integerBreak(self, n):
	# 	"""
	# 	:type n: int
	# 	:rType: int
	# 	"""
	# 	res,power,remainder=1,n/3,n%3
	# 	if n<=3: return 1 if n==2 else 2
	# 	for i in xrange(power): res*=3
	# 	if not remainder: return res
	# 	elif remainder==1: return res/3*4
	# 	else: return res*2
	def integerBreak(self, n):
		ret = 1
		i = 2
		while n / i >= 2:
			tmp = 0
			if n % i == 0:
				tmp = i ** (n / i)
			else:
				tmp = i ** (n / i - 1) * (n % i + i) 
			ret = tmp if ret < tmp else ret
			i += 1
		return ret

n=11
print Solution().integerBreak(n)
	