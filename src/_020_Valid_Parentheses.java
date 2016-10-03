import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author Shengyi
 *
 */

public class _020_Valid_Parentheses {
	public static  boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
        	char temp = s.charAt(i);
        	if (temp == ')') {
        		if (stack.isEmpty() || stack.pop() != '(') {
        			return false;
        		}
        	} else if (temp == ']') {
        		if (stack.isEmpty() || stack.pop() != '[') {
        			return false;
        		}
        	} else if (temp == '}') {
        		if (stack.isEmpty() || stack.pop() != '{') {
        			return false;
        		}
        	} else {
        		stack.push(temp);
        	}
        }
        
        //Need to check if the stack is empty or not. Not return true directly
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String input = "[]{}()";
		System.out.println(isValid(input));
	}
}
