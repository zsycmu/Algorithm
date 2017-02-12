/**
 * 
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * 
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * 
 * Return 6.
 * @author shengyizhang
 *
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class _374_Guess_Number_Higher_or_Lower {
	public int guessNumber(int n) {
        int start = 1;
        int end = n;
        
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (0 == guess(mid)) {
				return mid;
			} else if (guess(mid) == 1) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1;
    }
	
	private int guess(int input) {
		return 1;
	}
}
