package LinkedList;

import org.junit.Test;

public class middleOfLinkedlist {

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
		
		midEle(list1);
	}

	private void midEle(ListNode head) {
		ListNode curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		
        int mid = count/2;
        int tempC=0;
        while(head!=null){
            if(mid!=tempC){
                head = head.next;
                tempC++;
            }
            else break;
        }
        while(head!=null) {
        	System.out.println("Head Value : " +head.val);
        	head=  head.next;
        }
		
	}

	

	public ListNode addNode(int data) {
		return new ListNode(data);

	}
}
