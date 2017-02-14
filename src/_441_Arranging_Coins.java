/**
 * 
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * 
 * Example 1:
 * 
 * n = 5
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 * @author Shengyi
 *
 */
//Note: you need to take a look at binary search
public class _441_Arranging_Coins {
	public static int arrangeCoins(int n) {
		if (n <= 1) {
			return n;
		}
		
        long start = 0;
        long end = n;
        
        while (start <= end) {
        	long mid = start + (end - start) / 2;
        	long compare = mid * (1 + mid) / 2;
        	
        	if (compare <= n) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        
        return (int)start - 1;
    }
	
	public static void main(String[] args) {
		System.out.println(arrangeCoins(15));
	}
}
