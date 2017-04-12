import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * 
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * @author Shengyi
 *
 */

public class _524_Longest_Word_in_Dictionary_through_Deleting {
	// Note: 等真正想明白了在动手做题
	public static String findLongestWord(String s, List<String> d) {
		if (s == null || s.length() == 0 || d == null || d.size() == 0) {
            return "";
        } 
        
        Collections.sort(d);
		int[] count = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c - 'a']++;
		}
		
		String result = "";
		
		for (String str : d) {
			int index1 = 0;
			int index2 = 0;
			
			while (index1 < s.length() && index2 < str.length()) {
			    if (s.charAt(index1) == str.charAt(index2)) {
			        index1++;
			        index2++;
			    } else {
			        index1++;
			    }
			}
			
			if (index2 == str.length() && str.length() > result.length()) {
				result = str;
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>(Arrays.asList("ba","ab","a","b"));
		findLongestWord("bab", input);
	}
}
