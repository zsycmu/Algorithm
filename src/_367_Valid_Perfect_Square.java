/**
 * 
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16
 * Returns: True
 * Example 2:
 * 
 * Input: 14
 * Returns: False
 * @author shengyizhang
 *
 */

public class _367_Valid_Perfect_Square {
	public static boolean isPerfectSquare(int num) {
		long start = 0;
        long end = num;
        
        while (start <= end) {
        	long mid = start + (end - start) / 2;
        	long sqr = mid * mid;
        	if (sqr == num) {
        		return true;
        	} else if (sqr < num) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		isPerfectSquare(2147483647);
	}
}
