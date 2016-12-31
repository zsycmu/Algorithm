import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * 
 * @author Shengyi
 *
 */
public class _217_Contains_Duplicate {
	public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
        	return false;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i : nums) {
        	if (set.contains(i)) {
        		return true;
        	}
        	set.add(i);
        }
        
        return false;
    }
}
