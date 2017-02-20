/**
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * @author Shengyi
 *
 */
// Note: 
// 1. 如果最后没有返回，返回nums.length
// 2. swap的时候nums[i]要存到单独的变量里面

public class _268_Missing_Number {
	public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int index = 0;
        
        while (index < nums.length) {
        	while (index < nums.length && nums[index] != index) {
        		if (nums[index] < nums.length) {
        			int tempIndex = nums[index];
        			int temp = nums[index];
        			nums[index] = nums[tempIndex];
        			nums[tempIndex] = temp;
        		} else {
        			index++;
        		}
        	}
        	index++;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != i) {
        		return i;
        	}
        }
        
        return nums.length;
    }
	
	public static void main(String[] args) {
		int[] input = {3,2,0};
		missingNumber(input);
	}
}
