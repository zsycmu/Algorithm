/**
 * 
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 * 
 * @author shengyizhang
 *
 */
//Node: 输入没有特殊情况，词之间的唯一分割是空格。
public class _434_Number_of_Segments_in_a_String {
	public static int countSegments(String s) {
		if (s == null || s.length() == 0) {
        	return 0;
        }
        
        int result = 0;
        
        for (int i = 0; i < s.length(); ) {
        	char c = s.charAt(i);
        	if (c != ' ') {
        		result++;
        		while (c != ' ' && i < s.length()) {
        		    c = s.charAt(i);
        			i++;
        		}
        	} else {
        		i++;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String input = " hello ";
		System.out.println(countSegments(input));
	}
}
