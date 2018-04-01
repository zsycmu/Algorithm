package Facebook;

public class _01_leetcode_Ranges_sum {
	int[][] dp;

    public _01_leetcode_Ranges_sum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
    	int n = matrix[0].length;
    	
    	dp = new int[m][n];
    	dp[0][0] = matrix[0][0];
    	
    	for (int i = 1; i < m; i++) {
    		dp[i][0] = matrix[i][0] + dp[i - 1][0];
    	}
    	
    	for (int j = 1; j < n; j++) {
    		dp[0][j] = matrix[0][j] + dp[0][j - 1];
    	}
    	
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			dp[i][j] = matrix[i][j] - dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1];
    		}
    	}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null) {
            return 0;
        }
    	int result = dp[row2][col2];
    	if (col1 > 0) {
    		result = result - dp[row2][col1 - 1];
    	}
    	if (row1 > 0) {
    		result = result - dp[row1 - 1][col2];
    	}
    	if (col1 > 0 && row1 > 0) {
    		result += dp[row1 - 1][col1 - 1];
    	}
    	
        return result;
    }
}
