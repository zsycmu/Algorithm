import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * @author Shengyi
 *
 */
//Note: http://www.cnblogs.com/grandyang/p/6222149.html
//Do it again
//Mark everything as negtive when some number can fit the position
public class _448_Find_All_Numbers_Disappeared_in_an_Array {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
        	return list;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	int index = Math.abs(nums[i]) - 1;
        	nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		list.add(i + 1);
        	}
        }
        
        return list;
    }
}
