import java.util.Arrays;

/**
 * 
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * @author Shengyi
 *
 */
// Note: https://segmentfault.com/a/1190000003768736

public class _279_Perfect_Squares {
	public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for (int i = 0; i * i < dp.length; i++) {
        	dp[i * i] = 1;
        }
        
        for (int a = 0; a < dp.length; a++) {
        	for (int b = 0; a + b * b < dp.length; b++) {
        		dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
        	}
        }
        
        return dp[n];
    }
}
