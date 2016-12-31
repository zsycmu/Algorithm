import Util.ListNode;

/**
 * 
 * Reverse a singly linked list.
 * 
 * click to show more hints.
 * 
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @author Shengyi
 *
 */

public class _206_Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode pre = null;
        ListNode current = head;
        
        while (current != null) {
        	ListNode temp = current.next;
        	current.next = pre;
        	pre = current;
        	current = temp;
        }
        
        return pre;
    }
}
