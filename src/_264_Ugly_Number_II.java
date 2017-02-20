/**
 * 
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 * 
 * Hint:
 * 
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 * The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 * @author Shengyi
 *
 */
// Note: factor每次要乘以当前dp里面最小的数

public class _264_Ugly_Number_II {
	public static int nthUglyNumber(int n) {
		int[] dp = new int[n];
        
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        
        int index0 = 0;
        int index1 = 0;
        int index2 = 0;
        
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
        	dp[i] = Math.min(Math.min(factor2, factor3), factor5);
        	
        	if (dp[i] == factor2) {
        		factor2 = 2 * dp[++index0];
        	}
        	
        	if (dp[i] == factor3) {
        		factor3 = 3 * dp[++index1];
        	}
        	
        	if (dp[i] == factor5) {
        		factor5 = 5 * dp[++index2];
        	}
        }
        
        return dp[n - 1];
    }
	
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(15));
	}
}
