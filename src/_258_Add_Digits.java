/**
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint:
 * 
 * A naive implementation of the above process is trivial. Could you come up with other methods? 
 * @author Shengyi
 *
 */

public class _258_Add_Digits {
	public int addDigits(int num) {
        int temp = 0;
        
        while (num > 0) {
        	int val = num % 10;
        	temp += val;
        	num = num / 10;
        }
        
        if (temp < 10) {
        	return temp;
        } else {
        	return addDigits(temp);
        }
    }
}
