/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * @author Shengyi
 *
 */
//Redo
public class _283_Move_Zeroes {
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return;
        }
        
        int start = 0;
        
        while (start < nums.length) {
        	if (nums[start] != 0) {
        		start++;
        	} else {
        		int index = start;
        		while (index < nums.length && nums[index] == 0) {
        			index++;
        		}
        		if (index < nums.length) {
        			swap(nums, start, index);
        		}
        		start++;
        	}
        }
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
