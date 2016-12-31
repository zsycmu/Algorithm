import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 * @author Shengyi
 *
 */

public class _205_Isomorphic_Strings {
	//Notice this is two direction problem
	public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        }
        
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i);
        	char c2 = t.charAt(i);
        	
        	if (map1.containsKey(c1)) {
        		if (c2 != map1.get(c1) || c1 != map2.get(c2)) {
        			return false;
        		}
        	} else if (map2.containsKey(c2)) {
        		if (c1 != map2.get(c2)) {
        			return false;
        		}
        	} else {
        		map1.put(c1, c2);
        		map2.put(c2, c1);
        	}
        }
        
        return true;
    }
}
