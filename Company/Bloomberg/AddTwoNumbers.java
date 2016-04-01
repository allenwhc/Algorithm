public class AddTwoNumbers{
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){this.val=x;this.next=null;}

		public static void printList(ListNode head){
			while(head!=null){
				System.out.print(head.val);
				head=head.next;
				if(head!=null) System.out.print("->");
			}
			//System.out.println();
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;

		ListNode p=l1, q=l2;
		int len1=listLength(p), len2=listLength(q);
		ListNode sumL=new ListNode(-1);
		ListNode node=sumL;
		int sum=0;
		//int carry=0;
		while(p!=null || q!=null){
			if(p!=null) {sum+=p.val;p=p.next;}
			if(q!=null) {sum+=q.val;q=q.next;}

			node.next=new ListNode(sum%10);
			node=node.next;
			sum/=10;
		}

		if(sum!=0){
			node.next=new ListNode(sum%10);
			node=node.next;
		}
		return sumL.next;
	}

	private static ListNode reverseLinkedList(ListNode head){
		if(head==null) return null;
		ListNode prev=null,curr=head;
		ListNode next;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		} 
		return prev;
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
		ListNode l1=new ListNode(5);
		 ListNode tail=l1, print1=l1;
		// ListNode l1_1=new ListNode(4);
		// tail.next=l1_1;
		// tail=tail.next;
		// ListNode l1_2=new ListNode(3);
		// tail.next=l1_2;
		// tail=tail.next;
		// ListNode l1_3=new ListNode(7);
		// tail.next=l1_3;
		// tail=tail.next;

		// tail=null;
		ListNode l2=new ListNode(5);
		// tail=l2;
		 ListNode print2=l2;
		// ListNode l2_1=new ListNode(6);
		// tail.next=l2_1;
		// tail=tail.next;
		// ListNode l2_2=new ListNode(4);
		// tail.next=l2_2;
		// tail=tail.next;
		ListNode.printList(print1);
		System.out.print(" + ");
		ListNode.printList(print2);
		System.out.print(" = ");
		ListNode.printList(addTwoNumbers(l1,l2));
		System.out.println();
	}
}