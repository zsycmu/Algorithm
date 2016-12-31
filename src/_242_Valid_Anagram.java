import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author Shengyi
 *
 */

public class _242_Valid_Anagram {
	public boolean isAnagram(String s, String t) {
        if (s == null) {
        	return t == null;
        }
        
        if (t == null) {
        	return false;
        }
        
        if (s.length() != t.length()) {
        	return false;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	if (map.containsKey(temp)) {
        		map.put(temp, map.get(temp) + 1);
        	} else {
        		map.put(temp, 1);
        	}
        }
        
        for (int i = 0; i < t.length(); i++) {
        	char temp = t.charAt(i);
        	if (!map.containsKey(temp)) {
        		return false;
        	} else {
        		int count = map.get(temp);
        		if (count == 1) {
        			map.remove(temp);
        		} else {
        			map.put(temp, count - 1);
        		}
        	}
        }
        
        return map.isEmpty();
    }
}
