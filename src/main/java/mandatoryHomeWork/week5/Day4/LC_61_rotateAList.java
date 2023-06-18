package LinkedList;

import org.junit.Test;

public class rotateAList {

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
//		list1.next.next.next.next = addNode(5);
//		list1.next.next.next.next.next = addNode(5);
//		list1.next.next.next.next.next.next = addNode(6);
		int val = 2;
		rotate(list1, val);

	}

	// Time complexity is O(n)
	// Space complexicty is O(1)
	public ListNode rotate(ListNode head, int k) {
		//Init curr = head and prev for the newly created node
	    ListNode curr = head;
		ListNode prev = new ListNode();
		//Getting the size of input
		int len = size(head);
		
		//return head if head is null
		if(head==null || k==0 || head.next==null || k%len==0) {
			return head;
		}
		//taking the mod value to loop for the number of times
		k = k%len;
		for (int i = 0; i < k; i++) {
			//removing the last element and adding it curr value and resetting the curr with prev
			prev = removeLast(curr);
			prev.next = curr;
			curr= prev;
		}
		
//		while (prev != null) {
//		System.out.print(prev.val + " ");
//		prev = prev.next;
//	}
//	

		return prev;
    }

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
	
    ListNode removeLast(ListNode head) {	
		ListNode current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		ListNode temp =  current.next;
		current.next = null;
		return temp;
	}
	static int size(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}
