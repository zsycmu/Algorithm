/**
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author Shengyi
 *
 */

public class _136_Single_Number {
	public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	result = result ^ nums[i];
        }
        
        return result;
    }
}
