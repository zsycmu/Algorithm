/**
 * 
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1:
 * Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * @author shengyizhang
 *
 */

public class _414_Third_Maximum_Number {
	public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        
        for (int i : nums) {
        	if (i > first) {
        		third = second;
        		second = first;
        		first = i;
        	} else if (i > second && i < first) {
        		third = second;
        		second = i;
        	} else if (i > third && i < second) {
        		third = i;
        	}
        }
        
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }
}
