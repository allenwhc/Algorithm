
public class Solution {
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
			next=null;
		}
		
		public static void printList(ListNode head){
			while(head!=null){
				System.out.print(head.val);
				head=head.next;
				if(head!=null) System.out.print("->");
			}
			System.out.println();
		}
		
	}
	
	//Merge Sort
	public static ListNode mergeSort(ListNode head){
		if(head==null || head.next==null) return head;
		ListNode midNode=split(head);
		ListNode secondHead=midNode.next;
		midNode.next=null;
		return merge(mergeSort(head), mergeSort(secondHead));
	}
	
	private static ListNode merge(ListNode p, ListNode q){
		ListNode mergedHead=new ListNode(0);
		ListNode curr=mergedHead;
		while(p!=null && q!=null){
			if(p.val<q.val){
				curr.next=p;
				p=p.next;
			}
			else{
				curr.next=q;
				q=q.next;
			}
			curr=curr.next;
		}
		curr.next=(p==null)?q:p;
		return mergedHead.next;
	}
	
	private static ListNode split(ListNode head){
		if(head==null) return null;
		ListNode slow=head, fast=head;
		while(fast.next.next!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	//Insertion Sort
	public static ListNode insertionSort(ListNode head){
		if(head==null || head.next==null) return head;
		ListNode temp=new ListNode(Integer.MIN_VALUE);
		while(head!=null){
			ListNode prev=temp;
			ListNode curr=head;
			head=head.next;
			while(prev.next!=null && prev.next.val<=curr.val)
				prev=prev.next;
			curr.next=prev.next;
			prev.next=curr;
		}
		head=temp.next;
		temp.next=null;
		return head;
	}
	
	
	//Main Method
	public static void main(String[] args){
		ListNode head1=new ListNode(4);
		ListNode print=head1,prev=head1;
		ListNode n1=new ListNode(2);
		prev.next=n1;
		prev=prev.next;
		ListNode n2=new ListNode(3);
		prev.next=n2;
		prev=prev.next;
		ListNode n3=new ListNode(7);
		prev.next=n3;
		prev=prev.next;
		ListNode n4=new ListNode(5);
		prev.next=n4;
		prev=prev.next;
		ListNode n5=new ListNode(8);
		prev.next=n5;
		prev=prev.next;
		ListNode n6=new ListNode(6);
		prev.next=n6;
		prev=prev.next;
		System.out.print("The unsorted singly-linked list is: ");
		ListNode.printList(print);
		System.out.print("The sorted (Merge Sort) singly-linked list is: ");
		ListNode.printList(mergeSort(head1));
		
		ListNode head2=new ListNode(4);
		print=head2;
		prev=head2;
		n1=new ListNode(2);
		prev.next=n1;
		prev=prev.next;
		n2=new ListNode(3);
		prev.next=n2;
		prev=prev.next;
		n3=new ListNode(7);
		prev.next=n3;
		prev=prev.next;
		n4=new ListNode(5);
		prev.next=n4;
		prev=prev.next;
		n5=new ListNode(8);
		prev.next=n5;
		prev=prev.next;
		n6=new ListNode(6);
		prev.next=n6;
		prev=prev.next;
		System.out.print("The unsorted singly-linked list is: ");
		ListNode.printList(print);
		System.out.print("The sorted (Insertion Sort) singly-linked list is: ");
		ListNode.printList(insertionSort(head2));
	}
}
