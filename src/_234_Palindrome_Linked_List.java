import Util.ListNode;

/**
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * @author Shengyi
 *
 */

public class _234_Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
        	return true;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        
        while (second != null && second.next != null) {
        	first = first.next;
        	second = second.next.next;
        }
        
        ListNode newList = first.next;
        ListNode reverseNewList = reverseList(newList);
        
        while (reverseNewList != null) {
        	if (head.val != reverseNewList.val) {
        		return false;
        	}
        	
        	head = head.next;
        	reverseNewList = reverseNewList.next;
        }
        
        return true;
    }
	
	private ListNode reverseList(ListNode head) {
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
