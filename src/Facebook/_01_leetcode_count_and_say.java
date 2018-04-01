package Facebook;

public class _01_leetcode_count_and_say {
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
}
