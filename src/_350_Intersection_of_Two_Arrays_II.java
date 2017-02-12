import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * 
 * @author shengyizhang
 *
 */

public class _350_Intersection_of_Two_Arrays_II {
	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int start1 = 0;
        int start2 = 0;
        
        while (start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] < nums2[start2]) {
                start1++;
            } else if (nums1[start1] > nums2[start2]) {
                start2++;
            } else {
                list.add(nums1[start1]);
                start1++;
                start2++;
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
        	result[i] = list.get(i);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] input1 = {1,2,2,1};
		int[] input2 = {2,2};
		
		int[] result = intersect(input1, input2);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
