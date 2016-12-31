import Util.ListNode;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author Shengyi
 *
 */

public class _083_Remove_Duplicates_from_Sorted_List {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode first = head;
        
        while (first != null && first.next != null) {
        	ListNode index = first.next;
        	while (index != null && index.val == first.val) {
        		index = index.next;
        	}
        	first.next = index;
        	first = first.next;
        }
        
        return head;
    }
}
