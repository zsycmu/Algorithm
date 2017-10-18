/**
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * @author Shengyi
 *
 */

// Note: https://leetcode.com/problems/sum-of-two-integers/?tab=Description
// http://www.cnblogs.com/grandyang/p/5451942.html
public class _371_Sum_of_Two_Integers {
	public int getSum(int a, int b) {
        if (b == 0) {
        	return a;
        }
        
        int sum = a ^ b; // 不考虑进位
        int carry = (a & b) << 1; // 只考虑进位
        
        return getSum(sum, carry);
    }
}
