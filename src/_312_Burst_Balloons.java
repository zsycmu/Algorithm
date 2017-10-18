/**
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note: 
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example:
 * 
 * Given [3, 1, 5, 8]
 * 
 * Return 167
 * 
 *     nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @author Shengyi
 *
 */

// https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations

// 第一个气球不知道在哪儿， 最后一个气球更好找。

public class _312_Burst_Balloons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int[] newNum = new int[nums.length + 2];
        
        newNum[0] = 1;
        
        int n = 1;
        
        for (int x : nums) {
        	if (x > 0) {
        		newNum[n++] = x;
        	}
        }
        
        newNum[n++] = 1;
        
        int[][] dp = new int[n][n];
        
        for (int k = 2; k < n; k++) {
        	for (int l = 0; l < n - k; l++) {
        		int r = l + k;
        		for (int m = l + 1; m < r; m++) {
        			dp[l][r] = Math.max(dp[l][r], dp[l][m] + newNum[l] * newNum[m] * newNum[r] + dp[m][r]);
        		}
        	}
        }
        
        return dp[0][n - 1];
    }
}
