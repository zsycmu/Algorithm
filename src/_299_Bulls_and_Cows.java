import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * 
 * For example:
 * 
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * 
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * 
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * @author Shengyi
 *
 */

public class _299_Bulls_and_Cows {
	public String getHint(String secret, String guess) {
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        
        for (int i = 0; i < secret.length(); i++) {
        	char c = secret.charAt(i);
        	if (map.containsKey(c)) {
        		List<Integer> list = map.get(c);
        		list.add(i);
        		map.put(c, list);
        	} else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(c, list);
        	}
        }
        
        int a = 0;
        int b = 0;
        
        for (int i = 0; i < guess.length(); i++) {
        	char c = guess.charAt(i);
        	if (map.containsKey(c)) {
        		List<Integer> list = map.get(c);
        		if (list.contains(i)) {
        			a++;
        			list.remove(i);
        		} else {
        			if (list.size() != 0) {
        				b++;
        			}
        		}
        	}
        }
        
        //return a + "A" + b + "B";
    }
}
