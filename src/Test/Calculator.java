package Test;

import java.util.Stack;

public class Calculator {
	public int evaluateExpression(String[] expression) {
        // write your code here
        Stack<Integer> value = new Stack<Integer>();
        Stack<String> ops = new Stack<String>();
        
        for (int i = 0; i < expression.length; i++) {
            String s = expression[i];
            
            if (s.equals("(")) {
                ops.push(s);
            } else if (s.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    int a = value.pop();
                    int b = value.pop();
                    value.push(cal(b, a, ops.pop()));
                }
                ops.pop();
                
            } else if (s.equals("+") || s.equals("-")) {
                while (!ops.isEmpty() && (ops.peek().equals("*") || ops.peek().equals("/"))) {
                    int a = value.pop();
                    int b = value.pop();
                    value.push(cal(b, a, ops.pop()));
                }
                
                ops.push(s);
                
            } else if (s.equals("*") || s.equals("/")) {
                if (!ops.isEmpty() && (ops.peek().equals("*") || ops.peek().equals("/"))) {
                    int a = value.pop();
                    int b = value.pop();
                    value.push(cal(b, a, ops.pop()));
                }
                ops.push(s);
            } else {
                int temp = Integer.valueOf(s);
                value.push(temp);
            }
        }
        
        while (!ops.isEmpty()) {
            int a = value.pop();
            int b = value.pop();
            value.push(cal(b, a, ops.pop()));
        }
        
        return value.isEmpty() ? 0 : value.pop();
    }
    
    private int cal(int a, int b, String s) {
        if (s.equals("+")) {
            return a + b;
        } else if (s.equals("-")) {
            return a - b;
        } else if (s.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
    
    public static void main(String[] args) {
    	Calculator test = new Calculator();
    	int result = test.evaluateExpression(new String[] {"(", "1231231233","-", "3",")", "+", "1"});
    	System.out.println(result);
    }
}
