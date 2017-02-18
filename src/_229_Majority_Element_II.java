import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * Hint:
 * 
 * How many majority elements could it possibly have?
 * Do you have a better hint? Suggest it!
 * @author Shengyi
 *
 */

public class _229_Majority_Element_II {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
        	return result;
        }
        
        int first = 0;
        int second = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	if (num == first) {
        		count1++;
        	} else if (num == second) {
        		count2++;
        	} else if (count1 == 0) {
        		first = num;
        		count1++;
        	} else if (count2 == 0) {
        		second = num;
        		count2++;
        	} else {
        		count1--;
        		count2--;
        	}
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == first) {
        		count1++;
        	}
        	if (nums[i] == second) {
        		count2++;
        	}
        }
        
        if (count1 * 3 > nums.length) {
        	result.add(first);
        }
        
        if (first != second && count2 * 3 > nums.length) { 
        	//Notice here the two number is different.
        	result.add(second);
        }
        
        return result;
    }
}
