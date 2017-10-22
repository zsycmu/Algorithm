package OA;

import java.util.Stack;

public class Baseball {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        
        int sum = 0;
        Stack<Integer> s = new Stack<Integer>();
        
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                 if (!s.isEmpty()){
                     sum -= s.pop();
                 }
            } else if (ops[i].equals("D")) {
                if (!s.isEmpty()) {
                    int d = s.peek();//no pop
                    s.push(d * 2);
                    sum += d * 2;
                }
            } else if (ops[i].equals("+")) {
                if (s.size() > 1) {
                    int a = s.pop();
                    int b = s.peek();
                    int cur = a + b;
                    s.push(a);
                    s.push(cur);
                    sum = sum + a + b;
                }                
            } else {
                s.push(Integer.valueOf(ops[i]));
                sum += Integer.valueOf(ops[i]);
            }
        }
        
        return sum;
    }
}
