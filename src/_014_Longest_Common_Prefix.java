/**
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author Shengyi
 *
 */

public class _014_Longest_Common_Prefix {
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        }
        
        String result = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
        	String temp = strs[i];
        	int j = 0;
        	//Need to compare the length both of the string
        	for (; j < result.length() && j < temp.length(); j++) {
        		if (result.charAt(j) != temp.charAt(j)) {
        			break;
        		}
        	}
        	result = result.substring(0, j);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		//String[] input = {"abcd","abc", "abcadfsdf", "abcfalksjdfoaisudf"};
		String[] input2 = {"aa", "a"};
		System.out.println(longestCommonPrefix(input2));
	}
}
