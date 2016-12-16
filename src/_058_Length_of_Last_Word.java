/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * @author Shengyi
 *
 */

public class _058_Length_of_Last_Word {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int result = 0;
		
		s = s.trim();
		
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				result++;
			} else {
				break;
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		String input = "a";
		System.out.println(lengthOfLastWord(input));
	}
}
