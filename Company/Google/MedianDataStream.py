import bisect

class MedianFinder:
	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.heap=[]

	def addNum(self, num):
		"""
		Adds a num into the data structure.
		:type num: int
		:rtype: void
		"""
		bisect.insort(self.heap,num)

	def findMedian(self):
		"""
		Returns the median of current data stream
		:rtype: float
		"""
		nums=self.heap
		if len(nums)%2==0:
			return (nums[len(nums)/2]+nums[len(nums)/2-1])/2.0
		else:
			return nums[len(nums)/2]

	def print_heap(self):
		print "heap: ", self.heap

# Your MedianFinder object will be instantiated and called as such:
# mf = MedianFinder()
# mf.addNum(1)
# mf.findMedian()

data_stream=[-1,-2,0,-3,-4,-5]

mf=MedianFinder()
for d in data_stream:
	print "Add number: ", d
	mf.addNum(d)
	mf.print_heap()
	print "Median: ", mf.findMedian()