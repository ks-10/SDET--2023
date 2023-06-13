package LinkedList;

import org.junit.Test;

public class MergeList {

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
		list1.next.next = addNode(4);

		ListNode list2 = addNode(1);
		list2.next = addNode(3);
		list2.next.next = addNode(4);

		mergeTwoLists(list1, list2);
	}

	// Time complexity is O(n*m)
	// Space complexicty is O(n)
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// Init output node for the merged list
		ListNode out = new ListNode();
		ListNode curr = out;
		// if both the list are not null adding the values in increasing order
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				// System.out.println("Current : " +curr.next.val);
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}
		// adding the remaining values in both lists
		if (list1 != null) {
			curr.next = list1;
		} else {
			curr.next = list2;
		}
		// Printing the value and checking the output is valid
		while (out != null) {
			System.out.println(out.val);
			out = out.next;
		}

		return out.next;

	}

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
