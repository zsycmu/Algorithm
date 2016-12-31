import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * @author Shengyi
 *
 */
// One to one match from both sides
public class _290_Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
        	return false;
        }
        
        String[] arr = str.split(" ");
        
        if (pattern.length() != arr.length) {
        	return false;
        }
        
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        
        for (int i = 0; i < pattern.length(); i++) {
        	String key = String.valueOf(pattern.charAt(i));
        	String value = arr[i];
        	
        	if (map.containsKey(key)) {
        		if (!value.equals(map.get(key))) {
        			return false;
        		}
        	} else {
        		map.put(key, value);
        	}
        	
        	if (map2.containsKey(value)) {
        		if (!key.equals(map2.get(value))) {
        			return false;
        		}
        	} else {
        		map2.put(value, key);
        	}
        }
        
        return true;
    }
}
