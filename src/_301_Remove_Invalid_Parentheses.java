import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 * @author shengyizhang
 *
 */

public class _301_Remove_Invalid_Parentheses {
	public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        
        if (s == null) {
            return result;
        }
        
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            
            if (isValid(temp)) {
                result.add(temp);
                found = true;
            }
            
            if (found) {
                continue;
            }
            
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if (c != '(' && c != ')') {
                    continue;
                }
                
                String newString = temp.substring(0, i) + temp.substring(i + 1);
                
                if (!visited.contains(newString)) {
                    visited.add(newString);
                    queue.offer(newString);
                }
            }
        }
        
        return result;
    }
    
    private static boolean isValid(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
    	List<String> result = removeInvalidParentheses("(()");
    	
    	System.out.println(result);
    }
}
/**
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 * @author Shengyi
 *
 */

public class _301_Remove_Invalid_Parentheses {
    public List<String> removeInvalidParentheses(String s) {
        
    }
}
