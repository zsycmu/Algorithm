/**
 * 
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 * @author Shengyi
 *
 */
// Note: 如果余2，3，5不是0就要break
public class _263_Ugly_Number {
	public boolean isUgly(int num) {
        
		while (num >= 2) {
			if (num % 2 == 0) {
				num = num / 2;
			} else if (num % 3 == 0) {
				num = num / 3;
			} else if (num % 5 == 0) {
				num = num / 5;
			} else {
				break;
			}
		}
		
		return num == 1;
    }
}
