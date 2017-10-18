/**
 * 
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * @author shengyizhang
 *
 */

public class _410_Split_Array_Largest_Sum {
	public static int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        
        int start = max;
        int end = sum;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, m, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
    
    private static boolean isValid(int[] nums, int m, int max) {
        int count = 1;
        int tempSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            if (tempSum > max) {
                tempSum = nums[i];
                count++;
            }
            if (count > m) {
                return false;
            }
        }
        
        
        return true;
    }
    
    public static void main(String[] args) {
    	int[] input = {7,2,5,10,8};
    	System.out.println(splitArray(input, 2));
    }
}
