package Facebook;

import java.util.ArrayList;
import java.util.List;

public class _01_leetcode_combination_sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        helper(candidates, target, 0, 0, result, temp);
        return result;
    }
    
    public void helper(int[] candidates, int target, int index, int sum, List<List<Integer>>result, List<Integer> temp) {
        if (sum == target) {
            List<Integer> ans = new ArrayList<Integer>(temp);
            result.add(ans);
            return;
        }
        
        if (sum > target) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(candidates, target, i, sum + candidates[i], result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
