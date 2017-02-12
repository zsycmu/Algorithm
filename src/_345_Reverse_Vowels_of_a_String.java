/**
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 * @author shengyizhang
 *
 */

public class _345_Reverse_Vowels_of_a_String {
	public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
        	return s;
        }
        
        char[] chars = s.toCharArray();
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
        	if (!isVowels(chars[start])) {
        		start ++;
        	} else if (!isVowels(chars[end])) {
        		end--;
        	} else {
        		char temp = chars[start];
        		chars[start] = chars[end];
        		chars[end] = temp;
        		start++;
        		end--;
        	}
        }
        
        return new String(chars);
    }
	
	private boolean isVowels(char c) {
		String test = "aeiouAEIOU";
		return test.contains(String.valueOf(c));
	}
	
	public static void main(String[] args) {
		_345_Reverse_Vowels_of_a_String test = new _345_Reverse_Vowels_of_a_String();
		String input = "hello";
		test.reverseVowels(input);
	}
}
