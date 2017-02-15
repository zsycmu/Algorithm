import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 * click to show hint.
 * 
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 * @author Shengyi
 *
 */

class TrieNode {
	char val;
	boolean isTail;
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	
	public TrieNode() {
		
	}
	
	public TrieNode(char val) {
		this.val = val;
	}
}

class WordDictionary {
	
	TrieNode root;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
        	return;
        }
        
        TrieNode currNode = root;
        Map<Character, TrieNode> children = root.children;
        
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!children.containsKey(c)) {
        		TrieNode node = new TrieNode(c);
        		children.put(c, node);
        	}
        	currNode = children.get(c);
        	children = currNode.children;
        	
        	if (i == word.length() - 1) {
        		currNode.isTail = true;
        	}
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
        	return false;
        }
        
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode currNode) {
    	if (word == null) {
    		return false;
    	}
    	
    	if (word.length() == 0) {
    		return  currNode.isTail;
    	}
    	
        Map<Character, TrieNode> children = currNode.children;
        
    	char c = word.charAt(0);
    	
		if (children.containsKey(c)) {
			currNode = children.get(c);
			return search(word.substring(1), currNode);
		} else if (c == '.') {
    		for (char chr : children.keySet()) {
    			TrieNode thisNode = children.get(chr);
    			if (search(word.substring(1), thisNode)) {
    				return true;
    			}
    		}
    		return false;
    	} else {
    		//return false;
    	}
    }
}

public class _211_Add_and_Search_Word_Data_structure_design {

    public static void main(String[] args) {
    	WordDictionary test = new WordDictionary();
    	
    	test.addWord("te");
    	System.out.println(test.search("t."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */