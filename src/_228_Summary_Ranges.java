import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author Shengyi
 *
 */
// Notice boundary check.

public class _228_Summary_Ranges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        int start = 0;
        int end = 1;
        
        while (end < nums.length) {
        	if (nums[end] == nums[end - 1] + 1) {
        		while (end < nums.length && nums[end] == nums[end - 1] + 1) {
            		end++;
            	}
            	String temp = String.valueOf(nums[start] + "->" + nums[end - 1]);
            	result.add(temp);
            	start = end;
            	end++;
        	} else {
        		result.add(String.valueOf(nums[start]));
        		start++;
        		end++;
        	}
        	
        }
        
        if (start >= nums.length) {
        	return result;
        }
        
        if (nums[start] == nums[end - 1]) {
        	result.add(String.valueOf(nums[start]));
        } else {
        	String temp = String.valueOf(nums[start] + "->" + nums[end - 1]);
        	result.add(temp);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input = {1,2,3,5,6,7,9};
		System.out.println(summaryRanges(input));
	}
}
