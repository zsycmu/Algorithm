/**
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author Shengyi
 *
 */

public class _067_Add_Binary {
	public String addBinary(String a, String b) {
        if (a == null || b == null) {
        	return a == null ? b : a;
        }
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        
        //Here should be >=
        while (indexA >= 0 || indexB >= 0) {
        	int temp = 0;
        	
        	if (indexA >= 0) {
        		temp += (int)(a.charAt(indexA) - '0');
        		indexA--;
        	}
        	
        	if (indexB >= 0) {
        		temp += (int)(b.charAt(indexB) - '0');
        		indexB--;
        	}
        	
        	temp += carry;
        	
        	sb.insert(0, temp % 2);
        	carry = temp / 2;
        }
        
        if (carry != 0) {
        	sb.insert(0, carry);
        }
        
        return sb.toString();
    }
}
