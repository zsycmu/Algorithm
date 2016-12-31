import Util.ListNode;

/**
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author Shengyi
 *
 */

public class _203_Remove_Linked_List_Elements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		
		ListNode pre = new ListNode(0);
		ListNode pointer = pre;
		pre.next = head;
		
		while (pre != null && pre.next != null) {
			if (pre.next.val == val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}
		
		return pointer.next;
    }
}
