import Util.ListNode;

/**
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * @author Shengyi
 *
 */

public class _141_Linked_List_Cycle {
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }
        
        ListNode first = head;
        ListNode second = head;
        
        while (second != null && second.next != null) {
        	first = first.next;
        	second = second.next.next;
        	if (first == second) {
        		return true;
        	}
        }
        
        return false;
    }
}
