class RandomListNode(object):
	def __init__(self, x):
		self.label = x
		self.next = None
		self.random = None

class Solution(object):
	"""
		Hash table solution
		Time complexity: O(n), n is # of nodes in list
		Extra space: O(n)
	"""
	def copyRandomList(self, head):
		"""
		:type head: RandomListNode
		:rtype: RandomListNode
		"""
		if not head: return None
		p,copy,node_map=head,None,{}
		while p:
			copy=RandomListNode(p.label)
			node_map[p]=copy
			p=p.next
	
		for node in node_map.keys():
			copy=node_map[node]
			copy.next=node_map[node.next] if node.next else None
			copy.random=node_map[node.random] if node.random else None

		return node_map[head]

def printList(head):
	while head:
		print head.label,"(random:",str(head.random.label)+")" if head.random else "none)",
		head=head.next
		if head: print "->",

head=RandomListNode(1)
tail=printHead=head
# n1=RandomListNode(2)
# tail.next=n1
# tail=tail.next
# n2=RandomListNode(3)
# tail.next=n2
# tail=tail.next
# n3=RandomListNode(4)
# tail.next=n3
# tail=tail.next
# n4=RandomListNode(5)
# tail.next=n4
# tail=tail.next
# n5=RandomListNode(6)
# tail.next=n5
# tail=tail.next

head.random=head
# n1.random=n4
# n2.random=head
# n3.random=None
# n4.random=n5
# n5.random=n1

print "original list:",printList(printHead)
sol=Solution()
print "copied list:",printList(sol.copyRandomList(head))