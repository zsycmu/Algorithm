package Test;

import java.io.File;
import java.util.Scanner;

import Util.ListNode;

public class Test {

	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null) {
	            return null;
	        }
	        
	        ListNode dummyA = headA;
	        ListNode dummyB = headB;
	        
	        int lenA = getLen(headA);
	        int lenB = getLen(headB);
	        
	        if (lenA == lenB) {
	            return compareNode(dummyA, dummyB);
	        } else if (lenA < lenB) {
	            moveForward(dummyB, lenB - lenA);
	            return compareNode(dummyA, dummyB);
	        } else {
	            moveForward(dummyA, lenA - lenB);
	            return compareNode(dummyA, dummyB);
	        }
	    }
	    
	    private static ListNode compareNode(ListNode headA, ListNode headB) {
	        while (headA != null && headB != null) {
	            if (headA.val != headB.val) {
	                headA = headA.next;
	                headB = headB.next; 
	            } else {
	                return headA;
	            }
	        }
	        
	        return null;
	    }
	    
	    private static void moveForward(ListNode node, int k) {
	        while (k > 0) {
	            node = node.next;
	            k--;
	        }
	    }
	    
	    private static int getLen(ListNode node) {
	        int len = 0;
	        while (node != null) {
	            node = node.next;
	            len++;
	        }
	        
	        return len;
	    }

    public static void main(String[] args) throws Exception {
    	ListNode node = new ListNode(2);
    	node.next = new ListNode(3);
    	
    	ListNode node1 = new ListNode(3);
    	
    	System.out.print(getIntersectionNode(node, node1).val);
    }

}