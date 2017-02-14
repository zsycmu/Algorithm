import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @author Shengyi
 *
 */
//Note: pass
public class _438_Find_All_Anagrams_in_a_String {
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (s == null || p == null || s.length() < p.length()) {
        	return result;
        }
        
        int[] array = getCharArray(p);
        
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
        	String subString = s.substring(i, i + p.length());
        	int[] compareArray = getCharArray(subString);
        	if (Arrays.equals(array, compareArray)) {
        		result.add(i);
        	}
        }
        
        return result;
    }
	
	private static int[] getCharArray(String p) {
		if (p == null || p.length() == 0) {
			return new int[0];
		}
		
		int[] indexs = new int[26];
		
		for (int i = 0; i < p.length(); i++) {
			int index = p.charAt(i) - 'a';
			indexs[index]++;
		}
		
		return indexs;
	}
	
	public static void main(String[] args) {
		String input1 = "cbaebabacd";
		String input2 = "abc";
		
		System.out.println(findAnagrams(input1, input2));
	}
}
