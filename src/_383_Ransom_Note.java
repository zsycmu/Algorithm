/**
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * @author shengyizhang
 *
 */

public class _383_Ransom_Note {
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
        	int index = magazine.charAt(i) - 'a';
        	array[index]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
        	int index = ransomNote.charAt(i) - 'a';
        	array[index]--;
        	if (array[index] < 0) {
        		return false;
        	}
        }
        
        return true;
    }
}
