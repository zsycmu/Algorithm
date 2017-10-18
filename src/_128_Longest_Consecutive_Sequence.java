import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author shengyizhang
 *
 */

public class _128_Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i : nums) {
            set.add(i);
        }
        
        int count = 1;
        
        for (int i : nums) {
            
            if (set.contains(i)) {
                set.remove(i);
                int tempCount = 1;
                int index = i;
                while (set.contains(index + 1)) {
                    tempCount++;
                    set.remove(index + 1);
                    index++;
                }
                index = i;
                while (set.contains(index - 1)) {
                    tempCount++;
                    set.remove(index - 1);
                    index--;
                }
                
                count = Math.max(count, tempCount);
            }
        }
        
        return count;
    }
}
