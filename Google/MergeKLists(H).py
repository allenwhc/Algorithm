class ListNode(object):
	def __init__(self,x):
		self.val=x
		self.next=None

class Solution(object):
	def mergeKLists(self, lists):
		"""
		:type lists: List[ListNode]
		:rtype: ListNode
		"""
		n=len(lists)
		if n==0: return None
		return self.divideLists(0,n-1,lists)

	def divideLists(self, s, e, lists):
		"""
		:type s,e: int, lists: List[ListNode]
		"rType: ListNode
		"""
		if s==e: return lists[s]
		mid=(e-s)/2+s
		list1=self.divideLists(s,mid,lists)
		list2=self.divideLists(mid+1,e,lists)
		return self.mergeTwoLists(list1,list2)


	def mergeTwoLists(self, headA, headB):
		"""
		:type headA, headB: ListNode
		:rType: ListNode
		"""
		if headA is None: return headB
		if headB is None: return headA
		head=ListNode(0)
		p=head
		while headA is not None and headB is not None:
			if headA.val<=headB.val:
				p.next=headA
				headA=headA.next
			else:
				p.next=headB
				headB=headB.next
			p=p.next

		rest_head=headA if headA is not None else headB
		while rest_head is not None:
			p.next=rest_head
			rest_head=rest_head.next
			p=p.next

		return head.next

	def printList(self, head):
		while head is not None:
			print head.val,
			head=head.next
			if head is not None: print "->",
		print 

sol=Solution()
head1=ListNode(-3)
tail1,print1=head1,head1
n1_1=ListNode(2)
tail1.next=n1_1
tail1=tail1.next
print "List 1:",
sol.printList(print1)

head2=ListNode(-2)
tail2,print2=head2,head2
n2_1=ListNode(0)
tail2.next=n2_1
tail2=tail2.next
n2_2=ListNode(5)
tail2.next=n2_2
tail2=tail2.next
print "List 2:",
sol.printList(print2)

head3=ListNode(-4)
tail3,print3=head3,head3
n3_1=ListNode(1)
tail3.next=tail3
tail3=tail3.next
n3_2=ListNode(3)
tail3.next=n3_2
tail3=tail3.next
n3_3=ListNode(7)
tail3.next=n3_3
tail3=tail3.next
print "List 3:",
sol.printList(print3)

head4=ListNode(-1)
tail4,print4=head4,head4
n4_1=ListNode(6)
tail4.next=n4_1
tail4=tail4.next
print "List 4:",
sol.printList(print4)

lists=[head1,head2,head3,head4]
print "After merging:",sol.printList(sol.mergeKLists(lists))
