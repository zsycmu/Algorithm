import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Util.NestedInteger;

/**
 * 
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Note: You may assume that the string is well-formed:
 * 
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * 
 * Given s = "324",
 * 
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * 
 * Given s = "[123,[456,[789]]]",
 * 
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 * @author Shengyi
 *
 */
// Note: 

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  
 

public class _385_Mini_Parser {
	public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        
        String tempNum = "";
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
    		if (c == '[') {
    			NestedInteger nestedInteger = new NestedInteger();
    			stack.push(nestedInteger);
    		} else if (c == ']' || c == ',') {
    			if (tempNum.length() != 0) {
        			stack.peek().add(new NestedInteger(Integer.parseInt(tempNum)));
        		}
        		tempNum = "";
        		if (c == ']') {
        			NestedInteger nestedInteger = stack.pop();
            		if (!stack.isEmpty()) {
            			stack.peek().add(nestedInteger);
            		} else {
            			return nestedInteger;
            		}
        		}
        	} else {
        		tempNum = tempNum + String.valueOf(c);
        	}
        }
        
        if (tempNum != "") {
        	return new NestedInteger(Integer.parseInt(tempNum));
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		String s = "[123,[-456,[789]]]";
		_385_Mini_Parser test = new _385_Mini_Parser();
		test.deserialize(s);
	}
}
