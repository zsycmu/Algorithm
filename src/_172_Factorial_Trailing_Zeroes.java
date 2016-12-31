/**
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * @author Shengyi
 *
 */
//http://www.danielbit.com/blog/puzzle/leetcode/leetcode-factorial-trailing-zeroes
//http://blog.csdn.net/feliciafay/article/details/42336835
//重点再看
public class _172_Factorial_Trailing_Zeroes {
	public int trailingZeroes(int n) {
		if (n < 0) {
			return -1;
		}
		
        int result = 0;
        long x = 5;
        
        while (n >= x) {
        	result += n / x;
        	x = x * 5;
        }
        
        return result;
    }
}
