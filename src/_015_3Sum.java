import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 
 * @author Shengyi
 *
 */

public class _015_3Sum {
	public static  List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i++) {
        	if (i != 0 && nums[i] == nums[i - 1]) {
        		continue;
        	}
        	
        	int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
            	int temp = nums[i] + nums[start] + nums[end];
            	if (temp == 0) {
            		List<Integer> list = new ArrayList<Integer>();
            		list.add(nums[i]);
            		list.add(nums[start]);
            		list.add(nums[end]);
            		result.add(list);
            		
            		start++;
            		end--;
            		
            		while (start < end && nums[start] == nums[start - 1]) {
                		start++;
                	}
                	while (start < end && nums[end] == nums[end + 1]) {
                		end--;
                	}
                	
            	} else if (temp < 0) {
            		start++;
            	} else {
            		end--;
            	}
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(input));
	}
}
