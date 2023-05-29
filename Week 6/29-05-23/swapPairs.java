package LinkedList;

import org.junit.Test;

import LinkedList.reverseList2.ListNode;

public class swapPairs {

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
	 ListNode start = null;
	 int size = 0;
	@Test
	public void data() {
		ListNode list1 = addNode(1);
		list1.next = addNode(2);
		list1.next.next = addNode(3);
		list1.next.next.next = addNode(4);
//		list1.next.next.next.next = addNode(5);
//		list1.next.next.next.next.next = addNode(6);
//		list1.next.next.next.next.next.next = addNode(7);
		int val = 3;
		int val1 = 5;
	
		swap(list1);
	}
		public ListNode swap(ListNode head) {
			if(head==null|| head.next==null)
	            return head;
			
			ListNode curr = head;
			ListNode prev = new ListNode();
		
			
			while(curr!=null && curr.next!=null ){
				 prev.val = curr.next.val ;
				 curr.next.val = curr.val;
				 curr.val = prev.val;
				 curr = curr.next.next;

			}
	        
//			while (head != null) {
//				System.out.print(head.val + " ");
//				head = head.next;
//			}
	        
		

			return head;
	    }

		public ListNode addNode(int data) {
			return new ListNode(data);

		}
	
}
