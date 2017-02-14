/**
 * 
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * @author Shengyi
 *
 */
//Notice the reverse thinking.
public class _453_Minimum_Moves_to_Equal_Array_Elements {
	public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i : nums) {
        	if (i < min) {
        		min = i;
        	}
        }
        
        int result = 0;
        
        for (int i : nums) {
        	result += (i - min);
        }
        
        return result;
    }
}
