import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implement a MapSum class with insert, and sum methods.
 * 
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 * 
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 * 
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 * @author Shengyi
 *
 */
class Trie {
    char c;
    int sum = 0;
    Map<Character, Trie> children = new HashMap<Character, Trie>();

    public Trie() {
    }

    public Trie(char c, int sum) {
        this.c = c;
        this.sum = sum;
    }
}

public class _677_Map_Sum_Pairs {

	Trie root;
    Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public _677_Map_Sum_Pairs() {
        root = new Trie();
        map = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
    	if (key == null || key.length() == 0) {
        	return;
        }
        
        val = map.containsKey(key) ? val - Integer.parseInt(map.get(key).toString()) : val;
        Trie node = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (!node.children.containsKey(c)) {
                Trie newNode = new Trie(c, val);
                node.children.put(c, newNode);
            } else {
                Trie curNode = node.children.get(c);
                curNode.sum += val;
            }

            node = node.children.get(c);
        }
        
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return 0;
        }
        
        Trie node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.children.containsKey(c)) {
                return 0;
            }
            node = node.children.get(c);
            if (i == prefix.length() - 1) {
                return node.sum;
            }
        }
        
        return 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */