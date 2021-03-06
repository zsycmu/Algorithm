/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * 
 * @author Shengyi
 *
 */

public class _009_Palindrome_Number {
	public static boolean isPalindrome(int x) {
		//The x will be changed, so here need to copy x to other places.
		int compareTo = x;
        if (x < 0) {
        	return false;
        }
        
        long result = 0;
        
        while (x != 0) {
        	result = result * 10 + x % 10;
        	x = x / 10;
        }
        
        return result == (int)compareTo;
    }
	
	public static void main(String[] args) {
		int input = 123321;
		System.out.println(isPalindrome(input));
	}
}
