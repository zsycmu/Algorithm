/**
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @author shengyizhang
 *
 */
//Note: 注意是index>=
public class _415_Add_Strings {
	public String addStrings(String num1, String num2) {
		if (num1 == null || num2 == null) {
        	return num1 == null ? num2 : num1;
        }
        
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (index1 >= 0 || index2 >= 0 || carry != 0) {
        	int value = 0;
        	if (index1 >= 0) {
        		value += num1.charAt(index1) - '0';
        		index1--;
        	}
        	if (index2 >= 0) {
        		value += num2.charAt(index2) - '0';
        		index2--;
        	}
        	if (carry != 0) {
        		value += carry;
        	}
        	
        	sb.insert(0, (char)(value % 10 + '0'));
        	carry = value / 10;
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
