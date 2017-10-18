/**
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @author shengyizhang
 *
 */
// Note: Pass
public class _169_Majority_Element {
	public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int result = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] == result) {
        		count++;
        	} else {
        		count--;
        		if (count == 0) {
        			result = nums[i];
        			count++; // Remember to add this.
        		}
        	}
        }
        
        return result;
    }
}
