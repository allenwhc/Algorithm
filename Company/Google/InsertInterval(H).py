import heapq
class Interval(object):
	def __init__(self,s=0,e=0):
		self.start=s
		self.end=e

class Solution(object):
	# def __lt__(self,other):
	# 	return self.start<other.start

	def insert(self, intervals, newInterval):
		"""
		:type intervals: List[Interval]
		:type newInterval: Interval
		:rtype: List[Interval]
		"""
		if not len(intervals): return [newInterval]
		res=[]
		intervals.append(newInterval)
		intervals.sort(lambda x,y: cmp(x.start,y.start))
		# intervals=sorted(intervals,lambda x,y: -cmp(x.start,y.start))
		res.append(intervals[0])
		for i in range(1,len(intervals)):
			new_start,new_end=intervals[i].start,intervals[i].end
			if intervals[i].start<=res[-1].end:
				last_interval=res.pop()
				new_start=min(last_interval.start,intervals[i].start)
				new_end=max(last_interval.end,intervals[i].end)
			res.append(Interval(new_start,new_end))
		return res

sol=Solution()
startToEnd=[[1,2],[3,5],[6,7],[8,10],[12,16]]
intervals=[]
for i in startToEnd:
	intervals.append(Interval(i[0],i[1]))
newInterval=Interval(4,9)
print "Original interval:",
for i in intervals:
	print "(",i.start,",",i.end,")",
intervals=sol.insert(intervals,newInterval)
print "\n","New interval:",
for i in intervals:
	print "(",i.start,",",i.end,")",