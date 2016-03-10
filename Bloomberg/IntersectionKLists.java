import java.util.Arrays;

public class IntersectionKLists{
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

	public static ListNode intersectKLists(ListNode[] heads){
		return null;
	}

	private static ListNode intersectTwoLists(ListNode h1, ListNode h2){
		
	}

	public static void main(String[] args) {
		//List 1:
		ListNode head1=new ListNode(-3);
		ListNode tail1=head1, print1=head1;
		ListNode n1_1=new ListNode(-2);
		tail1.next=n1_1;
		tail1=tail1.next;
		ListNode n1_2=new ListNode(2);
		tail1.next=n1_2;
		tail1=tail1.next;
		ListNode n1_3=new ListNode(4);
		tail1.next=n1_3;
		tail1=tail1.next;
		ListNode.printList(print1);

		ListNode head2=new ListNode(-10);
		ListNode tail2=head2, print2=head2;
		ListNode n2_1=new ListNode(-7);
		tail2.next=n2_1;
		tail2=tail2.next;
		ListNode n2_2=new ListNode(0);
		tail2.next=n2_2;
		tail2=tail2.next;
		ListNode n2_3=new ListNode(2);
		tail2.next=n2_3;
		tail2=tail2.next;
		ListNode n2_4=new ListNode(4);
		tail2.next=n2_4;
		tail2=tail2.next;
		ListNode.printList(print2);

		ListNode head3=new ListNode(1);
		ListNode print3=head3, tail3=head3;
		ListNode n3_1=new ListNode(2);
		tail3.next=n3_1;
		tail3=tail3.next;
		ListNode n3_2=new ListNode(4);
		tail3.next=n3_2;
		tail3=tail3.next;
		ListNode.printList(print3);

		ListNode[] heads={head1,head2,head3};
		ListNode intersect=intersectKLists(heads);
		String v=(intersect==null)?"null":Integer.toString(intersect.val);
		System.out.println("Intersection: "+v);
	}
}