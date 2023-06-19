package LinkedList;

import java.util.Iterator;

import org.apache.commons.math3.exception.NullArgumentException;
import org.junit.Test;

import LinkedList.rotateAList.ListNode;
import LinkedList.sLinkedList.Snode;

public class reverseList2 {

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
		list1.next.next.next.next = addNode(5);
//		list1.next.next.next.next.next = addNode(6);
//		list1.next.next.next.next.next.next = addNode(7);
		int val = 3;
		int val1 = 5;
		
		rotate(list1, val,val1);

	}

	// Time complexity is O(n)
	// Space complexicty is O(1)
	public ListNode rotate(ListNode head, int left,int right ) {
		if(head==null|| head.next==null || left==right)
            return head;
		
		ListNode temp = new ListNode();
		temp.next = head;
        ListNode prev = temp;
      
        for (int i = 0; i < left-1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode temp1;
        
        for (int i = left; i < right; i++) {
        	temp1 = curr.next;
            curr.next = temp1.next;
            temp1.next = prev.next;
            prev.next = temp1;
        }
	

		return temp.next;
    }

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
	

}
