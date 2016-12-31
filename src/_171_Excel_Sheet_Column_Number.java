/**
 * 
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * @author Shengyi
 *
 */

public class _171_Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        int result = 0;
        int index = 0;
        
        while (index < s.length()) {
        	char c = s.charAt(index);
        	int temp = c - 'A' + 1;
        	
        	result = result * 26 + temp;
        	index++;
        }
        
        return result;
    }
}
