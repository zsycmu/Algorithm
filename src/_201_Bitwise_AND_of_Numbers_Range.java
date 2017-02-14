/**
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * @author Shengyi
 *
 */
//Note： Remember how to solve it.
public class _201_Bitwise_AND_of_Numbers_Range {
	public int rangeBitwiseAnd(int m, int n) {
        int mask = 0xffffffff;
        
        while ((m & mask) != (n & mask)) {
        	mask = mask << 1;
        }
        
        return m & mask;
    }
}
