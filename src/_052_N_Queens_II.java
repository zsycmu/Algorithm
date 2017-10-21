import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * 
 * @author shengyizhang
 *
 */

public class _052_N_Queens_II {
	int count = 0;
	public int totalNQueens(int n) {
        if (n == 0) {
        	return count;
        }
        
        StringBuilder sb = new StringBuilder();
        helper(sb, n, 0);
        
        return count;
    }
	
	private void helper(StringBuilder sb, int n, int line) {
		if (sb.length() > n) {
			return;
		}
		
		if (sb.length() == n) {
			List<String> tempResult = constructResult(sb.toString());
			count++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValidPoint(sb.toString(), line, i)) {
				sb.append(i);
				helper(sb, n, line + 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	private List<String> constructResult(String s) {
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
	
	private boolean isValidPoint(String input, int i, int j) {
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
}
