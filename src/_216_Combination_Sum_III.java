import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * @author Shengyi
 *
 */

public class _216_Combination_Sum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (k == 0) {
        	return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        helper(result, list, 0, k, n, 1);
        
        return result;
    }
	
	private void helper(List<List<Integer>> result, List<Integer> list, int sum, int k, int n, int start) {
		if (sum == n && list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			list.add(i);
			helper(result, list, sum + i, k, n, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
