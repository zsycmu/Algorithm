/**
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * @author shengyizhang
 *
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

public class _303_Range_Sum_Query_Immutable {
	private int[] dp;
    public _303_Range_Sum_Query_Immutable(int[] nums) {
        this.dp = new int[nums.length];
        int value = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	value += nums[i];
        	dp[i] = value;
        }
    }
    
    public int sumRange(int i, int j) {
        if (i > j) {
        	return 0;
        }
        
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
    
    public static void main(String[] args) {
    	int[] input = {-2,0,3,-5,2,-1};
    	_303_Range_Sum_Query_Immutable test = new _303_Range_Sum_Query_Immutable(input);
    	int result = test.sumRange(2, 5);
    	System.out.println(result);
    }
}
