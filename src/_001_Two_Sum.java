import java.util.HashMap;
import java.util.Map;

/**
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	UPDATE (2016/2/13):
	The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/

public class _001_Two_Sum {
	public int[] twoSum(int[] nums, int target) {
        
        int[] result = {0, 0};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            
            map.put(nums[i], i);
        }
        
        return result;
    }
}
