from collections import defaultdict,Counter
from operator import itemgetter
import math

def calculateRoot(start, end, target):
	# @param n: int
	# @return float
	if start>=end: return 0
	mid=(end-start)/2+start
	print mid,math.floor(mid*mid)
	if math.ceil(mid*mid)==target: return round(mid,2)
	elif math.ceil(mid*mid)>target: return calculateRoot(start,mid,target)
	else: return calculateRoot(mid+1,end,target)
n=10
print calculateRoot(0,n,n)

nums=[1,4,3,5,2]
for i in xrange(len(nums)):
	print nums
	nums=[x for x in nums[:i]+nums[i:][::-1]]
	print nums