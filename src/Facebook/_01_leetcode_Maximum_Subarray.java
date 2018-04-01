package Facebook;

public class _01_leetcode_Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            result = Math.max(result, sum);
        }
        
        return result;
    }
}
