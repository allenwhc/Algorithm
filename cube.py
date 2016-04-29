from collections import defaultdict,Counter
from operator import itemgetter,div
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

n1='123'
n2='123'
res=''
a=[(1,2),(3,4)]
b=[(0,0),(0,0)]
for x,y in zip(n1,n2):
	res+=str(int(x)+int(y))
print '{0:b}'.format(42)
print '{0:b}'.format(-42 & 0b11111111111111111111111111111111)