import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * @author Shengyi
 *
 */
//Notice the result needs upper case letter too.
public class _500_Keyboard_Row {
	public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        
        List<String> strs = new ArrayList<String>();
        
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	String s = word.toLowerCase();
        	if (s1.contains(s.substring(0, 1))) {
        		if (containsAll(s1, s)) {
        			strs.add(word);
        		}
        	} else if (s2.contains(s.substring(0, 1))) {
        		if (containsAll(s2, s)) {
        			strs.add(word);
        		}
        	} else if (s3.contains(s.substring(0, 1))) {
        		if (containsAll(s3, s)) {
        			strs.add(word);
        		}
        	}
        }
        
        String[] result = new String[strs.size()];
        
        for (int i = 0; i < result.length; i++) {
        	result[i] = strs.get(i);
        }
        
        return result;
    }
	
	private boolean containsAll(String s1, String s2) {
		for (int i = 0; i < s2.length(); i++) {
			if (s1.indexOf(s2.charAt(i)) == -1) {
				return false;
			}
		}
		
		return true;
	}
}
