/**
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author Shengyi
 *
 */
// Note: dp矩阵要一遍生成，再注意生成方法

public class _304_Range_Sum_Query_2D_Immutable {
	
	int[][] dp;

    public _304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
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
    
    public static void main(String[] args) {
    	int[][] input = {
    			{3, 0, 1, 4, 2},
    			{5, 6, 3, 2, 1},
    			{1, 2, 0, 1, 5},
    			{4, 1, 0, 1, 7},
    			{1, 0, 3, 0, 5},
    	};
    	_304_Range_Sum_Query_2D_Immutable test = new _304_Range_Sum_Query_2D_Immutable(input);
    	
    	System.out.println(test.sumRegion(2, 1, 4, 3));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */