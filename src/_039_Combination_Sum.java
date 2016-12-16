import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 * @author Shengyi
 *
 */

public class _039_Combination_Sum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			if (sum > target) {
				return;
			}
			list.add(candidates[i]);
			helper(candidates, target, sum + candidates[i], result, list, i);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
		System.out.println(combinationSum(candidates, 310));
	}
}
