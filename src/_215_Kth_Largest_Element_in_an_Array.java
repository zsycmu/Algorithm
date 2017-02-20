/**
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author Shengyi
 *
 */
//Note:

public class _215_Kth_Largest_Element_in_an_Array {
	public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        
        return findK(nums, 0, nums.length - 1, nums.length - k);
    }
	
	//private static int findK(int[] nums, int start, int end, int k) {
		int position = getPosition(nums, start ,end);
		if (position == k) {
			return nums[position];
		} else if (position < k) {
			return findK(nums, position, end, k);
		} else {
			return findK(nums, start, position, k);
		}
	}
	
	private static int getPosition(int[] nums, int start, int end) {
		int i = start;
		int j = end;
		
		int midPosition = (i + j) / 2;
		
		while (i < j) {
			while (nums[i] < nums[midPosition] && i < j) {
				i++;
			}
			while (nums[j] > nums[midPosition] && i < j) {
				j--;
			}
			swap(nums, i, j);
		}
		
		return j;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] input = {3,2,1,5,6,4};
		System.out.println(findKthLargest(input, 2));
	}
}
