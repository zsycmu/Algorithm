/**
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * @author Shengyi
 *
 */
//Do it again. Only consider one edge.
//Use binary search to do it again.
public class _209_Minimum_Size_Subarray_Sum {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int first = 0;
        int second = 0;
        int result = Integer.MAX_VALUE;
        
        while (first < nums.length && second < nums.length) {
        	int sum = 0;
        	while (second < nums.length && sum < s) {
        		sum += nums[second];
    			second++;
        	}
        	
        	while (sum >= s) {
        		result = Math.min(result, second - first + 1);
        		sum -= nums[first];
        		first++;
        	}
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
