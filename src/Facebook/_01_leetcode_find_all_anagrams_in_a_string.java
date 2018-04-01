package Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Implement the . anagramIndexOf() function找到anagram的index
举栗子
"leetcode".anagramIndexOf("doc") = 4
"leetcode".anagramIndexOf("index") = -1 //不存在
要考虑有空格 还有 %，和普通char一样对待

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @author Shengyi
 *
 */

public class _01_leetcode_find_all_anagrams_in_a_string {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        
        int[] temp = new int[256];
        
        for (int i = 0; i < p.length(); i++) {
            temp[p.charAt(i)]++;
        }
        
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] dup = temp.clone();
            int j = 0;
            while (j < p.length()) {
                dup[s.charAt(i + j)]--;
                if (dup[s.charAt(i + j)] < 0) {
                    break;
                }
                j++;
            }
            
            if (j == p.length()) {
                result.add(i);
            }
        }
        
        return result;
    }
}
