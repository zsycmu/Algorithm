/**
 * 
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * @author Shengyi
 *
 */
//Note:
public class _306_Additive_Number {
	//public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) {
        	return false;
        }
        
        boolean[] dp = new boolean[num.length() + 1];
        dp[0] = true;
        
        for (int n = 0; n < num.length(); n++) {
        	for (int m = 0; m < n; m++) {
        		for (int j = 0; j < m; j++) {
        			for (int i = 0; i < j; i++) {
        				String first = num.substring(i, j);
        				String second = num.substring(j, m);
        				String third = num.substring(m, n);
        				
        				if (first.length() == 0 || second.length() == 0 || third.length() == 0) {
        					continue;
        				}
        				
        				if (dp[i] && Integer.parseInt(third) == Integer.parseInt(first) + Integer.parseInt(second)) {
        					dp[n] = true;
        				}
        			}
        		}
        	}
        }
        
        return dp[num.length()];
    }
	
	public static void main(String[] args) {
		String input = "112358";
		System.out.println(isAdditiveNumber(input));
	}
}
