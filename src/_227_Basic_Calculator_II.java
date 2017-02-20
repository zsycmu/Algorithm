import java.util.Stack;

/**
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * @author Shengyi
 *
 */
// Note: http://www.cnblogs.com/grandyang/p/4601208.html
// 所犯错误
// 1. 如果输入只有一个数字，应该返回数字本身
// 2. 如果符号类型单一，需要单独查看stack是否为空
// 3. 如果是乘除所得的数字就push到原来的stack里面
//
// 每次得到数字之后看之前的operator，然后根据operator来操作数字

public class _227_Basic_Calculator_II {
	public static int calculate(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        s = s.replaceAll("\\s","");
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int start = 0;
        int end = 1;
        
        char previousOperator = '+';
        
        while (end <= s.length()) {
        	if (end < s.length() && s.charAt(end) != '+' && s.charAt(end) != '-' && s.charAt(end) != '*' && s.charAt(end) != '/') {
        		end++;
        	} else {
        		String number = s.substring(start, end).trim();
        		
        		if (start == 0) {
        			stack.add(Integer.valueOf(number));
        		} else {
        			previousOperator = s.charAt(start - 1);
            		
        			if (previousOperator == '+') {
            			stack.add(Integer.valueOf(number));
            		} else if (previousOperator == '-') {
            			stack.add(-Integer.valueOf(number));
            		} else if (previousOperator == '*') {
            			int num = stack.pop();
            			stack.push(num * Integer.valueOf(number));
            		} else {
            			int num = stack.pop();
            			stack.push(num / Integer.valueOf(number));
            		}
        		}
        		
        		start = end + 1;
        		end = start + 1;
        	}
        }
        
        int result = 0;
        
        while (!stack.isEmpty()) {
        	result += stack.pop();
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String input = "3 - 1";
		System.out.println(calculate(input));
	}
}
