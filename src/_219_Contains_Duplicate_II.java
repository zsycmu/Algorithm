import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * @author Shengyi
 *
 */

public class _219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return false;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	int temp = nums[i];
        	if (map.containsKey(temp)) {
        		if (Math.abs(map.get(temp) - i) <= k) {
        			return true;
        		}
        	}
        	map.put(temp, i);
        }
        
        return false;
    }
}
