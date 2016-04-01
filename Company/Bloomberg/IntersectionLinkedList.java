public class IntersectionLinkedList{
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){val=x;next=null;}
		public static void printList(ListNode head){
			while(head!=null){
				System.out.print(head.val);
				head=head.next;
				if(head!=null) System.out.print("->"); 
			}
			System.out.println();
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA==null || headB==null) return null;
		ListNode p=headA, q=headB;
		ListNode intersection=null;
		int lenA=listLength(p), lenB=listLength(q);
	//	System.out.println(lenA+","+lenB);
		p=(lenA<=lenB)?headA:headB;
		q=(p==headA)?headB:headA;
		int diff=(lenA>=lenB)?(lenA-lenB):(lenB-lenA);

		while(diff>0){
			if(q!=p) q=q.next;
			diff--;
		}
	//	System.out.println(p.val+","+q.val);

		while(p!=null && q!=null){
			if(p.val!=q.val){
				p=p.next;
				q=q.next;
			}
			else{
				return new ListNode(p.val);
			}
		}

		return null;
	}

	private static int listLength(ListNode head){
		int len=0;
		while(head!=null){
			len++;
			head=head.next;
		}
		return len;
	}

	public static void main(String[] args) {
		ListNode headA=new ListNode(-1);
		ListNode printA=headA, tailA=headA;
		ListNode a1=new ListNode(1);
		tailA.next=a1;
		tailA=tailA.next;
		ListNode a2=new ListNode(4);
		tailA.next=a2;
		tailA=tailA.next;
		ListNode a3=new ListNode(6);
		tailA.next=a3;
		tailA=tailA.next;
		ListNode a4=new ListNode(7);
		tailA.next=a4;
		tailA=tailA.next;
		ListNode.printList(printA);

		ListNode headB=new ListNode(-2);
		ListNode printB=headB, tailB=headB;
		ListNode b1=new ListNode(0);
		tailB.next=b1;
		tailB=tailB.next;
		ListNode b2=new ListNode(2);
		tailB.next=b2;
		tailB=tailB.next;
		ListNode b3=new ListNode(4);
		tailB.next=b3;
		tailB=tailB.next;
		ListNode b4=new ListNode(6);
		tailB.next=b4;
		tailB=tailB.next;
		ListNode b5=new ListNode(7);
		tailB.next=b5;
		tailB=tailB.next;
		ListNode.printList(printB);		

		ListNode.printList(getIntersectionNode(headA,headB));
	}

}