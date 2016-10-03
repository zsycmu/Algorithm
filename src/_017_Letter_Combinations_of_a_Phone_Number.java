import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

public class _017_Letter_Combinations_of_a_Phone_Number {
	public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) {
        	return result;
        }
        
        StringBuilder sb = new StringBuilder();
        String[] board = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        helper(digits, result, sb, board, 0);
        
        return result;
    }
	
	public static void helper(String digits, List<String> result, StringBuilder sb, String[] board, int index) {
		if (index == digits.length() && sb.length() == digits.length()) {
			String temp = sb.toString();
			result.add(temp);
			return;
		}
		
		for (int i = index; i < digits.length(); i++) {
			int number = digits.charAt(i) - '0';
			String temp = board[number];
			for (int j = 0; j < temp.length(); j++) {
				sb.append(temp.charAt(j));
				helper(digits, result, sb, board, i + 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String input = "23";
		System.out.println(letterCombinations(input));
	}
}
