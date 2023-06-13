package LinkedList;

import org.junit.Test;

public class reverse {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {
		}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	@Test
	public void data() {
		ListNode list1 = addNode(1);
		list1.next = addNode(2);
		list1.next.next = addNode(6);
		list1.next.next.next = addNode(3);
		list1.next.next.next.next = addNode(4);
		list1.next.next.next.next.next = addNode(5);
		list1.next.next.next.next.next.next = addNode(6);
	
		reverseList(list1);
	}

	
	 public ListNode reverseList(ListNode head) {
		 	ListNode curr = head;
			ListNode prev =null;
			ListNode next=null;
		while(curr!=null) {
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
		}
		while (prev != null) {
			System.out.print(prev.val + " ");
			prev = prev.next;
		}
	return prev;
	 }

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
