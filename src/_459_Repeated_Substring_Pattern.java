/**
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * 
 * Example 1:
 * Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * 
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * @author Shengyi
 *
 */
//Note: Notice the place it do plus 1
public class _459_Repeated_Substring_Pattern {
	public static boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) {
        	return false;
        }
        
        for (int i = 1; i < str.length() / 2 + 1; i++) {
        	String pattern = str.substring(0, i);
        	for (int j = i; j < str.length() - pattern.length() + 1; j = j + pattern.length()) {
        		String match = str.substring(j, j + pattern.length());
        		if (!pattern.equals(match)) {
        			break;
        		}
        		if (j == str.length() - pattern.length()) {
        			return true;
        		}
        	}
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		String input = "abab";
		System.out.println(repeatedSubstringPattern(input));
	}
}
