/**
 * 
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * @author Shengyi
 *
 */
public class _028_Implement_strStr {
	public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) { //empty string is also a valid input
        	return -1;
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
        	int j = 0;
        	for (; j < needle.length(); j++) {
        		if (haystack.charAt(i + j) != needle.charAt(j)) {
        			break;
        		}
        	}
        	if (j == needle.length()) {
        		return i;
        	}
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		String haystack = "thisisatest";
		String needle = "this";
		
		System.out.println(strStr(haystack, needle));
	}
}
