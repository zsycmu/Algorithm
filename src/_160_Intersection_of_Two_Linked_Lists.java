import Util.ListNode;

/**
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 ¡ú a2
 *                    ¨K
 *                      c1 ¡ú c2 ¡ú c3
 *                    ¨J            
 * B:     b1 ¡ú b2 ¡ú b3
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * @author Shengyi
 *
 */

public class _160_Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        int diff = Math.abs(lenA - lenB);
        
        if (lenA < lenB) {
        	ListNode temp = headA;
        	headA = headB;
        	headB = temp;
        }
        
        while (diff > 0) {
        	headA = headA.next;
        	diff--;
        }
        
        while (headA != null && headB != null) {
        	if (headA == headB) {
        		return headA;
        	}
        	headA = headA.next;
        	headB = headB.next;
        }
        
        return null;
    }
	
	private int getLength(ListNode head) {
		int result = 0;
		while (head != null) {
			head = head.next;
			result++;
		}
		return result;
	}
}
