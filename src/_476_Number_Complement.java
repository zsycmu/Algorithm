/**
 * 
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * @author Shengyi
 *
 */
// Note: 0 is a special case.
public class _476_Number_Complement {
	public int findComplement(int num) {
		if (num == 0) {
			return 1; 
		}
		
        int result = num;
        
        int index = 0;
        int cast = 0x80000000;
        
        while (index < 32 && (num & cast) == 0) {
    		cast = cast >>> 1;
    		index++;
    	}
        
        while (index < 32) {
        	result = result ^ cast;
        	cast = cast >>> 1;
        	index++;
        }
        
        return result;
    }
}
