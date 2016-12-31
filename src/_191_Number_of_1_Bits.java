/**
 * 
 * Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ¡¯11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * @author Shengyi
 *
 */

public class _191_Number_of_1_Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int result = 0;
        
        while (n != 0) {
        	if ((n & 1) != 0) {
        		result++;
        	}
        	n >>>= 1;
        }
        
        return result;
    }
}
