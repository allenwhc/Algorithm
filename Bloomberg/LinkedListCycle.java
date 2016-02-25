public class LinkedListCycle{
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;next=null;}

		public static void printList(ListNode head){
			while(head!=null){
				System.out.print(head.val);
				head=head.next;
				if(head!=null) System.out.print("->");
			}
			System.out.println();
		}
	}

	public static boolean hasCycle(ListNode head){
		if(head==null || head.next==null) return false;
		ListNode slow=head, fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==null || fast==null) return false;
			if(slow==fast) return true;
		} 
		return false;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode tail=head;
		ListNode n1=new ListNode(2);
		tail.next=n1;
		tail=tail.next;
		ListNode n2=new ListNode(3);
		tail.next=n2;
		tail=tail.next;
		ListNode n3=new ListNode(4);
		tail.next=n3;
		tail=tail.next;
		ListNode n4=new ListNode(5);
		tail.next=n4;
		tail=tail.next;

		tail.next=n2;
		tail=tail.next;
		System.out.println(hasCycle(head));
	}
}