/**
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Subscribe to see which companies asked this question
 * @author Shengyi
 *
 */

public class _066_Plus_One {
	public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
        	return digits;
        }
        
        int carry = 0;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        
        if (digits[digits.length - 1] < 10) {
        	return digits;
        }
        
        for (int i = digits.length - 1; i >= 0; i--) {
        	int temp = digits[i] + carry;
        	digits[i] = temp % 10;
        	carry = temp / 10;
        }
        
        if (carry == 0) {
        	return digits;
        }
        
        int[] newResult = new int[digits.length + 1];
        newResult[0] = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
        	newResult[i + 1] = digits[i];
        }
        
        return newResult;
    }
	
	public static void main(String[] args) {
		int[] input = {9};
		
		int[] result = plusOne(input);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
