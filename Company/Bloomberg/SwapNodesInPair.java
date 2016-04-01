public class SwapNodesInPair{
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

	public static ListNode swapPairs(ListNode head){
		if(head==null || head.next==null) return head;
		ListNode temp=new ListNode(-1);
		temp.next=head;
		ListNode curr=head;
		head=temp;
		ListNode prev=head;

		while(curr!=null && curr.next!=null){
			ListNode next=curr.next;
			curr.next=next.next;
			next.next=curr;
			prev.next=next;
			prev=curr;
			curr=curr.next;
		}
		head=head.next;
		temp=null;
		return head;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode print=head,tail=head;
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

		ListNode.printList(print);
		ListNode.printList(swapPairs(head));
	}
}