/**
 * 
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * 
 * Example 1:
 * 
 * Input:
 * 3
 * 
 * Output:
 * 3
 * Example 2:
 * 
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * @author shengyizhang
 *
 */
//http://blog.csdn.net/qq508618087/article/details/52582162
/*
 * 分析可以得出一位有９个数字，二位数有90个数字，三位数有900个数，依次类推．因此可以每次增加一位数字，看n是否还在这个范围内．例如给定n = 150，首先一位有９个数字，所以位数可以＋１，这样n-9 = 141. 然后２位的数字有２＊９０= 180，大于１４１，所以目标数字肯定是２位的．然后求具体落在哪个数字．可以用10+(141-1)/2 = 80求出．再求具体落在哪一位上，可以用(141-1)%2＝０求出为第０位，即８．如此即可．
 */

public class _400_Nth_Digit {
	public int findNthDigit(int n) {
        //9 90 900 9000 90000
		
		
    }
}
