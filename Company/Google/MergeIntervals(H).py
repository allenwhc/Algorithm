class Interval(object):
	def __init__(self,s=0,e=0):
		self.start=s
		self.end=e

class Solution(object):
	def merge(self, intervals):
		# @intervals: List[Interval]
		# @return: List[Interval]
		if not intervals: return []
		intervals.sort(key=lambda x: x.start)
		q=[intervals[0]]
		for i in xrange(1, len(intervals)):
			if not q: q.append(intervals[i])
			else:
				prev,curr=q.pop(),intervals[i]
				if prev.end>=curr.start:
					prev.end=max(curr.end, prev.end)
					q.append(prev)
				else: 
					q.append(prev)
					q.append(curr)
		return q

intervals=[Interval(2,6),Interval(1,3),Interval(8,10),Interval(15,18)]
print 'Merged intervals:',
for i in Solution().merge(intervals):
	print '(%s-%s)'%(str(i.start),str(i.end)),