/**
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * 
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * @author Shengyi
 *
 */
// Note: Pass
public class _485_Max_Consecutive_Ones {
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int count = 0;
        int result = 0;
        int index = 0;
        
        while (index < nums.length) {
        	if (nums[index] == 1) {
        		count++;
        		result = Math.max(result, count);
        	} else {
        		count = 0;
        	}
        	index++;
        }
        
        return result;
    }
}
