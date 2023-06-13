package LinkedList;

import org.junit.Test;

public class RemoveDupfromSortedList {

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
		list1.next = addNode(1);
		list1.next.next = addNode(2);
		list1.next.next.next = addNode(3);
		list1.next.next.next.next = addNode(3);
		removeDup(list1);
	}

	// Time complexity is O(n)
	// Space complexicty is O(1)
	public ListNode removeDup(ListNode head) {

		ListNode curr = head;

		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;

			} else {
				curr = curr.next;
			}
		}
//		while (head != null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		return head;
	}

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
