package LinkedList;

import org.junit.Test;

public class RemoveValue {

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
		int val = 6;
		removeElements(list1,val);
	}

	// Time complexity is O(n)
	// Space complexicty is O(1)
	 public ListNode removeElements(ListNode head, int val) {
		  ListNode temp = new ListNode(0);
		  temp.next = head;

	        ListNode previous = temp;
	        ListNode current = head;

	        while (current != null) {
	            if (current.val == val) {
	                previous.next = current.next;
	            } else {
	                previous = current;
	            }
	            current = current.next;
	        }
	        

	        return temp.next;
	 }

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
