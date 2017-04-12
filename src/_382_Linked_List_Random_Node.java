import java.util.Random;

import Util.ListNode;

/**
 * 
 * 
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * 
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * 
 * Example:
 * 
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 * @author Shengyi
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Note: 了解水塘抽样法

public class _382_Linked_List_Random_Node {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
	ListNode head;
	Random random;
	
    public _382_Linked_List_Random_Node(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	int val = 0;
    	int count = 1;
    	ListNode index = head;
    	
        while (index != null) {
        	int num = random.nextInt(count);
        	if (num == 0) {
        		val = index.val; // 注意这里不能直接return
        	}
        	count++;
        	index = index.next;
        }
        
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */