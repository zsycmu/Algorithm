import Util.ListNode;

/**
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Shengyi
 * 
 */

public class _002_Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode result = new ListNode(0);
        ListNode index = result;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int temp = carry;
            
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            
            int value = temp % 10;
            index.next = new ListNode(value);
            carry = temp / 10;
            index = index.next;
        }
        
        return result.next;
    }
}
