/**
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases.
 * @author Shengyi
 *
 */

public class _168_Excel_Sheet_Column_Title {
	//Redo
	public static String convertToTitle(int n) {
        if (n == 0) {
        	return "";
        }
        
        String result = "";
        
        while (n - 1 >= 0) {
        	int temp = (n - 1) % 26;
        	result = (char)(temp + 'A') + result;
        	n = (n - 1) / 26;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(2));
	}
}
