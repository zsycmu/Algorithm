import Util.ListNode;

/**
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 * @author Shengyi
 *
 */
// Note: Pass
public class _328_Odd_Even_Linked_List {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }
        
        ListNode even = head;
        ListNode odd = head.next;
        
        ListNode evenPointer = even;
        ListNode oddPointer = odd;
        
        while (oddPointer != null && oddPointer.next != null) {
            evenPointer.next = oddPointer.next;
            evenPointer = evenPointer.next;
            oddPointer.next = evenPointer.next;
            oddPointer = oddPointer.next;
        }
        
        evenPointer.next = odd;
        
        return even;
    }
}
