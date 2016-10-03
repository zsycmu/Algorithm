import Util.ListNode;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author Shengyi
 *
 */

public class _024_Swap_Nodes_in_Pairs {
	public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode pre = new ListNode(0);
        ListNode dummy = pre;
        pre.next = head;
        
        ListNode first = head;
        
        while (first != null && first.next != null) {
        	ListNode second = first.next;
        	ListNode next = second.next;
        	second.next = first;
        	first.next = next;
        	pre.next = second;
        	pre = first;
        	first = pre.next;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		ListNode result = swapPairs(head);
		
		while (result != null) {
			System.out.println(result.val + " ");
			result = result.next;
		}
	}
}
