/**
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * [show hint]
 * 
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 * @author Shengyi
 *
 */

public class _189_Rotate_Array {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
        
        revert(nums, 0, nums.length - 1);
        revert(nums, 0, k - 1);
        revert(nums, k, nums.length - 1);
    }
	
	private void revert(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
