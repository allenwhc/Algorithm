class MovingAverage(object):
	def __init__(self, size):
		self.sz=size
		self.q=[]

	def next(self, val):
		if len(self.q)<self.sz:
			self.q.append(val)
		else:
			self.q.pop(0)
			self.q.append(val)
		return float(sum([x for x in self.q]))/float(len(self.q))

m =MovingAverage(3)
print m.next(1)
print m.next(10)
print m.next(3)
print m.next(5)