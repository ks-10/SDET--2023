package LinkedList;

import org.junit.Test;

public class isPalindrome {

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
		list1.next = addNode(0);
		list1.next.next = addNode(0);
	//	list1.next.next.next = addNode(1);
		
	
		System.out.println(isPalindrome(list1));
	}

	



	public boolean isPalindrome(ListNode head) {
		 	boolean flag =  false;
		 	ListNode cmp = copyListNode(head);
		 	ListNode a = head;
		 	ListNode b = null;
		 	ListNode c =null;
		 	
		 	while(a!=null) {
		 		c = a.next;
		 		a.next = b;
		 		b=a;
		 		a=c;
		 		
		 	}
		 	
//		 	while (cmp != null) {
//				System.out.print(cmp.val + " ");
//				cmp = cmp.next;
//			}
//		 	System.out.println();
//		 	while (b != null) {
//				System.out.print(b.val + " ");
//				b = b.next;
//			}

		 	while(cmp!=null && b!=null) {
		 		System.out.println(cmp.val);
		 		System.out.println(b.val);
		 		if(cmp.val!=b.val) {
		 			return false;
		 		}
		 		cmp =cmp.next;
		 		b= b.next;
		 	}
		 	
	return true;
	 }
	
	public ListNode copyListNode(ListNode head) {
	    if (head == null) {
	        return null;
	    }

	    // Create a new head node with the same value as the original head
	    ListNode newHead = new ListNode(head.val);
	    ListNode current = head.next;
	    ListNode newCurrent = newHead;

	    // Traverse the original list and create new nodes with the same values
	    while (current != null) {
	        ListNode newNode = new ListNode(current.val);
	        newCurrent.next = newNode;
	        
	        current = current.next;
	        newCurrent = newCurrent.next;
	    }

	    return newHead;
	}

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
