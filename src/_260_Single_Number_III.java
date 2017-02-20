/**
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @author Shengyi
 *
 */
// Note: 先将两个数分到不同的组里面。

public class _260_Single_Number_III {
	public int[] singleNumber(int[] nums) {
		int[] result = new int[2];
        
		if (nums == null || nums.length == 0) {
        	return result;
        }
        
        int xor = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	xor = xor ^ nums[i];
        }
        
        int lowerBit = xor & -xor;
        int num1 = 0;
        int num2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	if ((nums[i] & lowerBit) == 0) {
        		num1 = num1 ^ nums[i];
        	} else {
        		num2 = num2 ^ nums[i];
        	}
        }
        
        result[0] = num1;
        result[1] = num2;
        
        return result;
    }
}
