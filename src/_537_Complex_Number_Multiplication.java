/**
 * 
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * 
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * 
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 * @author shengyizhang
 *
 */
// Note: Pass
public class _537_Complex_Number_Multiplication {
	public static String complexNumberMultiply(String a, String b) {
        int a1 = Integer.parseInt(a.substring(0, a.indexOf('+')));
        int b1 = Integer.parseInt(a.substring(a.indexOf('+') + 1, a.indexOf('i')));
        int a2 = Integer.parseInt(b.substring(0, b.indexOf('+')));
        int b2 = Integer.parseInt(b.substring(b.indexOf('+') + 1, b.indexOf('i')));
        
        int firstPart = a1 * a2 - (b1 * b2);
        int secondPart = a1 * b2 + a2 * b1;
        
        return String.valueOf(firstPart) + "+" +String.valueOf(secondPart) + "i";
    }
	
	public static void main(String[] args) {
		String a = "1+1i";
		String b = "1+1i";
		System.out.println(complexNumberMultiply(a, b));
	}
}
