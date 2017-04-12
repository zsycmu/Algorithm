/**
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * @author Shengyi
 *
 */
// Note: Pass
public class _557_Reverse_Words_in_a_String_III {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        
        char[] array = s.toCharArray();
        
        int first = 0;
        int second = 0;
        
        while (second < s.length()) {
        	while (second < s.length() && array[second] != ' ') {
        		second++;
        	}
        	
        	swap(array, first, second - 1);
        	first = second + 1;
        	second = first;
        	
        	if (first > s.length() - 1) {
        		break;
        	}
        }
        
        return String.copyValueOf(array);
    }
	
	private void swap(char[] array, int start, int end) {
		int first = start;
		int second = end;
		
		while (first < second) {
			char temp = array[first];
			array[first] = array[second];
			array[second] = temp;
			first++;
			second--;
		}
	}
}
