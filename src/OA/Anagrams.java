package OA;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        
        int[] temp = new int[256];
        
        for (int i = 0; i < p.length(); i++) {
            temp[p.charAt(i)]++;
        }
        
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] dup = temp.clone();
            int j = 0;
            while (j < p.length()) {
                dup[s.charAt(i + j)]--;
                if (dup[s.charAt(i + j)] < 0) {
                    break;
                }
                j++;
            }
            
            if (j == p.length()) {
                result.add(i);
            }
        }
        
        return result;
    }
}
