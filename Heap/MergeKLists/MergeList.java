import java.util.PriorityQueue;

public class MergeList{
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;next=null;}
	}

	public static ListNode mergeKLists(ListNode[] lists){
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
		if(isEmptyLists(lists)) return null;
		while(!isEmptyLists(lists)){
			for(int i=0; i<lists.length; i++){
				if(lists[i]!=null){
					heap.offer(lists[i].val);
					lists[i]=lists[i].next;
				}
			}
		}
		
		ListNode head=new ListNode(heap.poll());
		ListNode tail=head;
		while(heap.size()>0){
			ListNode node=new ListNode(heap.poll());
			tail.next=node;
			tail=tail.next;
		}
		return head;
	}

	private static boolean isEmptyLists(ListNode[] lists){
		for(ListNode head:lists)
			if(head!=null) return false;
		return true;
	}

	public static ListNode createLinkedList(int[] nodeValues){
		ListNode head=new ListNode(nodeValues[0]);
		ListNode tail=head;
		for(int i=1; i<nodeValues.length; i++){
			ListNode node=new ListNode(nodeValues[i]);
			tail.next=node;
			tail=tail.next;
		}
		return head;
	}

	public static void printList(ListNode head){
		System.out.print("The linked list is: ");
		while(head!=null){
			System.out.print(head.val);
			head=head.next;
			if(head!=null) System.out.print("->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] val1={1,4,7,10,13};
		int[] val2={2,5,8,11};
		int[] val3={3,6,9};
		ListNode list1=createLinkedList(val1);
		ListNode list2=createLinkedList(val2);
		ListNode list3=createLinkedList(val3);
		printList(list1);
		printList(list2);
		printList(list3);
		System.out.println("After merging:");
		ListNode[] lists={list1,list2,list3};
		printList(mergeKLists(lists));
	}
}