/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 * @author Shengyi
 *
 */
// Note: https://segmentfault.com/a/1190000003709497
public class _221_Maximal_Square {
	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        	return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        
        int max = 0;
        
        for (int i = 0; i < m; i++) {
        	if (matrix[i][0] == '1') {
        		max = 1;
        		dp[i][0] = 1;
        	}
        }
        
        for (int j = 0; j < n; j++) {
        	if (matrix[0][j] == '1') {
        		max = 1;
        		dp[0][j] = 1;
        	}
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
            	if (matrix[i][j] == '1') {
            		dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            		max = Math.max(max, dp[i][j]);
            	}
            }
        }
        
        return max * max;
    }
}
