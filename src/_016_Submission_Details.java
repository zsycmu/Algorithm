import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *     
 * @author Shengyi
 *
 */
public class _016_Submission_Details {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		Arrays.sort(nums);
		
		int result = 0;
		int distance = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			
			while (start < end) {
				int temp = nums[i] + nums[start] + nums[end];
				int diff = Math.abs(target - temp);
				if (diff < distance) {
					distance = diff;
					result = temp;
				}
				
				if (temp == target) {
					return target;
				} else if (temp < target) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		return result;
    }
}
