import Util.ListNode;

/**
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 *    Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Shengyi
 *
 */

public class _019_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
        	return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        dummy.next = head;
        ListNode second = head;
        
        while (n > 0) {
        	//Here need to check second if the second is null pointer
        	if (second == null) {
        		break;
        	}
        	second = second.next;
        	n--;
        }
        
        while (second != null) {
        	first = first.next;
        	second = second.next;
        }
        
        first.next = first.next.next;
        
        return dummy.next;
    }
}
