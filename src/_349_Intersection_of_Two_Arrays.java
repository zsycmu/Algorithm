import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * @author shengyizhang
 *
 */

public class _349_Intersection_of_Two_Arrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
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
                if (list.size() == 0) {
                    list.add(nums1[start1]);
                } else {
                    if (list.get(list.size() - 1) != nums1[start1]) {
                        list.add(nums1[start1]);
                    }
                }
                
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
		
		int[] result = intersection(input1, input2);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
