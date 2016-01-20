
public class OddEven{
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val=x;
			this.next=null;
		}

		public static void print(ListNode head){
			while(head!=null){
				System.out.print(head.val);
				head=head.next;
				if(head!=null) System.out.print("->");
			}
			System.out.println();
		}
	}

	public static ListNode oddEvenList(ListNode head){
		if(head==null || head.next==null || head.next.next==null) return head;
		ListNode preHead=new ListNode(0);
		preHead.next=head;
		ListNode curr=head.next;
		ListNode temp=curr.next;
		curr.next=temp.next;
		temp.next=curr;
		head.next=temp;
		head=curr;
		curr=curr.next;

		while(curr!=null && curr.next!=null){
			temp.next=curr.next;
			temp=curr.next;
			curr.next=temp.next;
			temp.next=head;
			curr=curr.next;
		}

		//Restore linked list
		head=preHead.next;
		preHead=null;
		return head;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode print=head, tail=head;
		ListNode l1=new ListNode(2);
		tail.next=l1;
		tail=tail.next;
		ListNode l2=new ListNode(3);
		tail.next=l2;
		tail=tail.next;
		ListNode l3=new ListNode(4);
		tail.next=l3;
		tail=tail.next;
		ListNode l4=new ListNode(5);
		tail.next=l4;
		tail=tail.next;
		ListNode l5=new ListNode(6);
		tail.next=l5;
		tail=tail.next;
		ListNode l6=new ListNode(7);
		tail.next=l6;
		tail=tail.next;

		ListNode.print(print);
		ListNode.print(oddEvenList(head));

	}
}