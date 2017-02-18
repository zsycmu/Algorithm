/**
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author Shengyi
 *
 */
// Note: pass
public class _238_Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length ==0) {
        	return new int[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	dp[i] = nums[i] * dp[i - 1];
        }
        
        
        int right = 1;
        
        for (int i = dp.length - 1; i >= 1; i--) {
        	dp[i] = right * dp[i - 1];
        	right = right * nums[i];
        }
        
        dp[0] = right;
        
        return dp;
    }
}
