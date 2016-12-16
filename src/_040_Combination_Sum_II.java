import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * @author Shengyi
 *
 */

public class _040_Combination_Sum_II {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0) {
        	return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        helper(candidates, target, 0, result, list, 0);
        
        return result;
    }
	
	public static void helper(int[] candidates, int target, int sum, List<List<Integer>> result, List<Integer> list, int start) {
		if (sum == target) {
			List<Integer> tempResult = new ArrayList<Integer>(list);
			result.add(tempResult);
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			//This is important to avoid stack over flow
			if (i != start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (target < sum) {
				return;
			}
			
			list.add(candidates[i]);
			helper(candidates, target, sum + candidates[i], result, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		System.out.println(combinationSum2(candidates, 27));
	}
}
