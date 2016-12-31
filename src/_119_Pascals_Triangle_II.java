import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author Shengyi
 *
 */

public class _119_Pascals_Triangle_II {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        
        while(rowIndex > 0) {
        	List<Integer> current = new ArrayList<Integer>();
        	current.add(1);
        	for (int i = 1; i < pre.size(); i++) {
        		current.add(pre.get(i) + pre.get(i - 1));
        	}
        	current.add(1);
        	pre = current;
        	rowIndex--;
        }
        
        return pre;
    }
}
