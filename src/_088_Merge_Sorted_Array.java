/**
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * @author Shengyi
 *
 */

public class _088_Merge_Sorted_Array {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0 || nums1.length == 0) {
        	return;
        }
        
        int index = nums1.length - 1;
        
        while (m  > 0 && n > 0) {
        	if (nums1[m - 1] > nums2[n - 1]) {
        		nums1[index] = nums1[m - 1];
        		m--;
        	} else {
        		nums1[index] = nums2[n - 1];
        		n--;
        	}
        	index--;
        }
        
        while (m > 0) {
        	nums1[index] = nums1[m - 1];
        	m--;
        	index--;
        }
        
        while (n > 0) {
        	nums1[index] = nums2[n - 1];
        	n--;
        	index--;
        }
    }
	
	public static void main(String[] args) {
		int[] input1 = {0};
		int[] input2 = {1};
		merge(input1, 0, input2, 1);
	}
}
