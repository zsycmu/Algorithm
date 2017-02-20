/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * @author Shengyi
 *
 */
// Note: 从最左下方的点开始搜索

public class _240_Search_a_2D_Matrix_II {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
        	return false;
        }
        
        return search(matrix, matrix.length - 1, 0, target);
    }
	
	private boolean search(int[][] matrix, int row, int col, int target) {
		if (row < 0 || col > matrix[0].length - 1) {
			return false;
		}
		
		if (matrix[row][col] == target) {
			return true;
		} else if (matrix[row][col] < target) {
			return search(matrix, row, col + 1, target);
		} else {
			return search(matrix, row - 1, col, target);
		}
	}
}
