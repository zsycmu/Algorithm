/**
 * 
 * 
 * @author Shengyi
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 */

public class _007_Reverse_Integer {
	public static int reverse(int x) {
        long result = 0;
        
        while (x != 0) {
        	result = result * 10 + x % 10;
        	x = x / 10;
        	
        	//When the result exceed the integer range, return 0 directly
        	if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
    			return 0;
    		}
        }
        
        return (int) result;
    }
	
	public static void main(String[] args) {
		int input = 1534236469;
		int result = reverse(input);
		System.out.println(result);
	}
}
