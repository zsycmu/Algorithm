import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * @author shengyizhang
 *
 */

public class _387_First_Unique_Character_in_a_String {
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] array = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            array[index]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
