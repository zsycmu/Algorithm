import Util.ListNode;

/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author Shengyi
 *
 */

public class _021_Merge_Two_Sorted_Lists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
        	return l1 == null ? l2 : l1;
        }
        
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        
        while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		pointer.next = l1;
        		l1 = l1.next;
        	} else {
        		pointer.next = l2;
        		l2 = l2.next;
        	}
        	pointer = pointer.next;
        }
        
        if (l1 != null) {
        	pointer.next = l1;
        }
        
        if (l2 != null) {
        	pointer.next = l2;
        }
        
        return result.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		
		ListNode result = mergeTwoLists(l1, l2);
	}
}
