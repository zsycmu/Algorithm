import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * @author shengyizhang
 *
 */

public class _051_N_Queens {
	public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (n == 0) {
        	return result;
        }
        
        StringBuilder sb = new StringBuilder();
        helper(result, sb, n, 0);
        
        return result;
    }
	
	private static void helper(List<List<String>> result, StringBuilder sb, int n, int line) {
		if (sb.length() > n) {
			return;
		}
		
		if (sb.length() == n) {
			List<String> tempResult = constructResult(sb.toString());
			result.add(tempResult);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValidPoint(sb.toString(), line, i)) {
				sb.append(i);
				helper(result, sb, n, line + 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	private static List<String> constructResult(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}
		
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			char c = s.charAt(i);
			for (int j = 0; j < s.length(); j++) {
				if (j != (int)(c - '0')) {
					sb.append('.');
				} else {
					sb.append('Q');
				}
			}
			result.add(sb.toString());
		}
		
		return result;
	}
	
	private static boolean isValidPoint(String input, int i, int j) {
		for (int k = 0; k < input.length(); k++) {
			int x = k;
			int y = input.charAt(k) - '0';
			
			if (x == i || y == j) {
				return false;
			}
			
			if (Math.abs(x - i) == Math.abs(y - j)) {
				return false;
			}
			
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		List<List<String>> result = solveNQueens(5);
		
		System.out.println(result);
	}
}
