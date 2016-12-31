import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author Shengyi
 *
 */

public class _118_Pascals_Triangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
        	return result;
        }
        
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        
        while(numRows > 0) {
        	List<Integer> current = new ArrayList<Integer>();
        	current.add(1);
        	for (int i = 1; i < pre.size(); i++) {
        		current.add(pre.get(i) + pre.get(i - 1));
        	}
        	current.add(1);
        	result.add(pre);
        	pre = current;
        	numRows--;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> result = generate(6);
		System.out.println(result);
	}
}
