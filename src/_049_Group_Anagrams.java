import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * 
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author Shengyi
 *
 */

public class _049_Group_Anagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
        	return result;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
        	String s = strs[i];
        	String sSort = sort(s);
        	if (map.containsKey(sSort)) {
        		List<String> list = map.get(sSort);
        		list.add(s);
        	} else {
        		List<String> list = new ArrayList<String>();
        		list.add(s);
        		map.put(sSort, list);
        	}
        }
        
        for (String s : map.keySet()) {
        	result.add(map.get(s));
        }
        
        return result;
    }
	
	private static String sort (String input) {
		if (input == null || input.length() == 0) {
			return "";
		}
		
		char[] chars = input.toCharArray();
		
		Arrays.sort(chars);
		
		return new String(chars);
	}
	
	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(input));
	}
}
