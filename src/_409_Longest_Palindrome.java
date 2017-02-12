import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * @author shengyizhang
 *
 */
// Takecare of the case "ccc"。如果里面有多个奇数的字符，可以取其中最大偶数个。

public class _409_Longest_Palindrome {
	public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	} else {
        		map.put(c, 1);
        	}
        }
        
        boolean single = false;
        int length = 0;
        
        for (char c : map.keySet()) {
        	if (map.get(c) % 2 == 0) {
        		length += map.get(c);
        	} else {
        		single = true;
        		length = length + map.get(c) - 1;
        	}
        }
        
        return single ? length + 1 : length;
    }
}
