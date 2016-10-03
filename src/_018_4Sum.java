import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * 
 * @author Shengyi
 *
 */
public class _018_4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
        	if (i != 0 && nums[i] == nums[i - 1]) {
        		continue;
        	}
        	for (int j = i + 1; j < nums.length - 2; j++) {
        		if (j != i + 1 && nums[j] == nums[j - 1]) {
            		continue;
            	}
        		
        		int start = j + 1;
        		int end = nums.length - 1;
        		
        		while (start < end) {
        			int temp = nums[i] + nums[j] + nums[start] + nums[end];
        			
        			if (temp == target) {
        				List<Integer> tempList = new ArrayList<Integer>();
        				tempList.add(nums[i]);
        				tempList.add(nums[j]);
        				tempList.add(nums[start]);
        				tempList.add(nums[end]);
        				result.add(tempList);
        				start++;
        				end--;
        				
        				while (start < end && nums[start] == nums[start - 1]) {
        					start++;
        				}
        				
        				while (start < end && nums[end] == nums[end + 1]) {
        					end--;
        				}
        			} else if (temp < target) {
        				start++;
        			} else {
        				end--;
        			}
        		}
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> result  = fourSum(input, 0);
		System.out.println(result);
	}
}
