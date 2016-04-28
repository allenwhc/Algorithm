from collections import defaultdict
class LRUCache(object):
	class LRUQueue(object):
		def __init__(self,k=0,v=0):
			self.key=k
			self.value=v
			self.prev=None
			self.next=None

	def __init__(self, capacity):
		self.capacity=capacity
		self.map=defaultdict(self.LRUQueue)
		self.front=None
		self.end=None

	def get(self, key):
		# @param key: int
		# @return: int
		if not self.front: return -1	# The cache is empty
		if key not in self.map: return -1 # The key is not in cache
		value=self.map[key].value
		self.remove(self.map[key])
		self.insert(self.map[key])
		return value

	def set(self, key, value):
		# @param key: int
		# @return: None
		new_node=self.LRUQueue(key,value)
		if key in self.map:
			self.remove(self.map[key])
			self.insert(new_node)
		else:
			if len(self.map)<self.capacity:
				self.insert(new_node)
			else:
				self.map.pop(self.end.key,None)
				self.remove(self.end)
				self.insert(new_node)
		self.map[key]=new_node
		print self.map

	def insert(self, node):
		# @param node: LRUQueue
		# @return None
		node.next=self.front
		node.prev=None
		if self.front: self.front.prev=node
		self.front=node
		if not self.end: self.end=node

	def remove(self, node):
		# @param node: LRUQueue
		# @return None
		prev_node,next_node=node.prev,node.next
		if prev_node: prev_node.next=next_node
		else: self.front=next_node	# if remove the head node
		if next_node: next_node.prev=prev_node
		else: self.end=prev_node	# if remove the end node

	def printQueue(self):
		head=self.front
		while head:
			print (head.key, head.value),
			head=head.next
			if head: print '->',
		print 
capacity=5
pending_data=[(1,3),(2,4),(3,7),(5,10),(1,7),(2,-3),(7,3),(11,0),(5,7)]
retrieve_key=[1,0,2,11,5,3]
lru=LRUCache(5)
lru.set(1,3)
lru.set(2,4)
lru.set(3,7)
lru.set(4,3)
lru.set(5,10)
lru.set(7,4)
lru.printQueue()
print 'key=',lru.get(2)
lru.printQueue()