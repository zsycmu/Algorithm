import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * 
 * 
 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * @author Shengyi
 *
 */
// Note: 注意input是一个数字的情况

public class _241_Different_Ways_to_Add_Parentheses {
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (input == null || input.length() == 0) {
        	return result;
        }
        
        for (int i = 0; i < input.length(); i++) {
        	char c = input.charAt(i);
        	if (c == '+' || c == '-' || c == '*') {
        		List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
        		List<Integer> rightList = diffWaysToCompute(input.substring(i + 1, input.length()));
        		
        		for (int left : leftList) {
        			for (int right : rightList) {
        				if (c == '+') {
        					result.add(left + right);
        				}
        				if (c == '-') {
        					result.add(left - right);
        				}
        				if (c == '*') {
        					result.add(left * right);
        				}
        			}
        		}
        	}
        }
        
        if (result.isEmpty()) {
        	result.add(Integer.valueOf(input));
        }
        
        return result;
    }
}
