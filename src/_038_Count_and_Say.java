/**
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author Shengyi
 *
 */

public class _038_Count_and_Say {
	public static String countAndSay(int n) {
        if (n <= 0) {
        	return "";
        }
        
        String tempResult = "1";
        
        while (n - 1 > 0) {
        	StringBuilder sb = new StringBuilder();
        	int count = 1;
        	int i = 1;
        	
        	for (i = 1; i < tempResult.length(); i++) {
        		if (tempResult.charAt(i) == tempResult.charAt(i - 1)) {
        			count++;
        		} else {
        			sb.append(count);
        			sb.append(tempResult.charAt(i - 1));
        			count = 1; //This is really important for reset
        		}
        	}
        	
        	sb.append(count);
        	sb.append(tempResult.charAt(i - 1));
        	
        	tempResult = sb.toString();
        	
        	n--;
        }
        
        return tempResult;
    }
	
	public static void main(String[] args) {
		int n = 0;
		while (n < 10) {
			String result = countAndSay(n);
			System.out.println(result);
			n++;
		}
	}
}

