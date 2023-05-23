package LinkedList;

import org.junit.Test;

import LinkedList.RemoveValue.ListNode;

public class removeNthElement {

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
		list1.next.next = addNode(3);
		list1.next.next.next = addNode(4);
		list1.next.next.next.next = addNode(5);
		list1.next.next.next.next.next = addNode(6);
//		list1.next.next.next.next.next.next = addNode(6);

		int a = 2;
		midEle(list1, a);
	}

	private void midEle(ListNode head, int a) {
		//Create a new node for the output and point it to head
		ListNode temp = new ListNode();
		temp.next = head;
		//Create a another node to get the count of the given input
		ListNode curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		//Create a previous node to add the values to ouput node
		ListNode previous = temp;
		//Create a current node to check for the condition
		ListNode current = head;
		//Manual counter for checking if the given k index matches
		int count1 = 0;
		//Loop till the end of the node
		while (current != null) {
			//check if the count1 matches the given index if matches assign the previous node to next node of the current node
			if (count1 == (count - a)) {
				previous.next = current.next;
				count1++;
			//else add the current node values to previous node	
			} else {
				previous = current;
				count1++;
			}
			//increment the current value
			current = current.next;

		}
		//Printing the output for checking 
		while (temp != null) {
			System.out.println("Head Value : " + temp.next.val);
			temp = temp.next;
		}

	}

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
