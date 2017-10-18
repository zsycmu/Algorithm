/**
 * 
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * @author Shengyi
 *
 */

public class _329_Longest_Increasing_Path_in_a_Matrix {
	public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        	return 0;
        }
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		max = Math.max(max, helper(matrix, i, j, dp));
        	}
        }
        
        return max;
    }
	
	private int helper(int[][] matrix, int i, int j, int[][] dp) {
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int max = 0;
		
		if (i != 0 && matrix[i][j] < matrix[i - 1][j]) {
			dp[i][j] = Math.max(dp[i][j], helper(matrix, i - 1, j, dp));
		}
		
		if (i != matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
			dp[i][j] = Math.max(dp[i][j], helper(matrix, i + 1, j, dp));
		}
		
		if (j != 0 && matrix[i][j] < matrix[i][j - 1]) {
			dp[i][j] = Math.max(dp[i][j], helper(matrix, i, j - 1, dp));
		}
		
		if (j != matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
			dp[i][j] = Math.max(dp[i][j], helper(matrix, i, j + 1, dp));
		}
		
		return ++dp[i][j];
    }
}
