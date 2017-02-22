/**
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * @author Shengyi
 *
 */
// Note: 为什么最后返回的是start？

public class _287_Find_the_Duplicate_Number {
	public static int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        
        while (start <= end) {
        	int mid = start + (end - start) / 2;
        	int count = 0;
        	for (int i = 0; i < nums.length; i++) {
        		if (nums[i] <= mid) {
        			count++;
        		}
        	}
        	
        	if (count <= mid) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        
        return start;
    }
	
	public static void main(String[] args) {
		int[] input = {1,1,2};
		findDuplicate(input);
	}
}
