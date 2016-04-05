import random,itertools
# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
def knows(a, b):
	global celebirty_index
	if_know=False
	if b==celebirty_index and a!=celebirty_index:
		if_know=True
	elif b!=celebirty_index and a==celebirty_index:
		if_know=False
	else:
		if_know=bool(random.getrandbits(1))
	return if_know

class Solution(object):
	"""
		Brute force solution
		Time complexity: O(n^2)
		Extra space: O(1)
	"""
	def findCelebrity(self, n):
		"""
		:type n: int
		:rtype: int
		"""
		for i,j in itertools.product(range(n),range(1)):
			is_celebirty=False
			for j in range(n):
				if (i!=j and knows(i,j)) or (i!=j and not knows(j,i)): 
					is_celebirty=False
					break
				is_celebirty=True
			if j==n-1 and is_celebirty: return i
		return -1

	"""
		Time complexity: O(n)
		Extra space: O(1)
	"""
	def findCelebrity2(self, n):
		"""
		:type n: int
		:rtype: int
		"""
		x=0
		for i in range(n):
			if knows(x,i):
				x=i
		if any(x!=i and knows(x,i) for i in range(n)):
			return -1
		if any(x!=i and not knows(i,x) for i in range(n)):
			return -1
		return x

n=10
celebirty_index=13 # Assume the 5th people is the celebirty.
print "The celebirty is:",celebirty_index
sol=Solution()
print "The celebirty is:",sol.findCelebrity(n)
print "The celebirty is:",sol.findCelebrity2(n)