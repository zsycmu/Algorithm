//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 
// * Implement a trie with insert, search, and startsWith methods.
// * 
// * Note:
// * You may assume that all inputs are consist of lowercase letters a-z.
// * @author Shengyi
// *
// */
////Notice: important question, do it again.
//class TrieNode {
//	char val;
//	boolean isTail;
//	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//	
//	public TrieNode() {
//		
//	}
//	
//	public TrieNode(char val) {
//		this.val = val;
//	}
//}
//
//class Trie {
//	
//	TrieNode root;
//	Map<Character, TrieNode> children;
//	
//	/** Initialize your data structure here. */
//    public Trie() {
//        root = new TrieNode();
//        children = root.children;
//    }
//    
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if (word == null || word.length() == 0) {
//        	return;
//        }
//        
//        TrieNode currentNode = root;
//        Map<Character, TrieNode>  currentChildren = root.children;
//        
//        for (int i = 0; i < word.length(); i++) {
//        	char c = word.charAt(i);
//        	
//        	if (!currentChildren.containsKey(c)) {
//        		TrieNode node = new TrieNode(c);
//        		currentChildren.put(c, node);
//        	}
//        	
//        	currentNode = currentChildren.get(c);
//    		currentChildren = currentNode.children;
//        	
//        	if (i == word.length() - 1) {
//        		currentNode.isTail = true;
//        	}
//        }
//        
//        System.out.println("Insert complete. ");
//    }
//    
//    public TrieNode searchWord(String word) {
//    	if (word == null || word.length() == 0) {
//    		return null;
//    	}
//    	
//    	TrieNode currentNode = root;
//    	Map<Character, TrieNode>  currentChildren = root.children;
//    	
//    	for (int i = 0; i < word.length(); i++) {
//    		char c = word.charAt(i);
//    		
//    		if (!currentChildren.containsKey(c)) {
//    			return null;
//    		} else {
//    			currentNode = currentChildren.get(c);
//        		currentChildren = currentNode.children;
//    		}
//    	}
//    	
//    	return currentNode;
//    }
//    
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//    	TrieNode node = searchWord(word);
//        return node != null && node.isTail;
//    }
//    
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        return searchWord(prefix) != null;
//    }
//}
//
//public class _208_Implement_Trie_Prefix_Tree {
//	public static void main(String[] args) {
//		Trie trie = new Trie();
//		trie.insert("test");
//		trie.insert("tenant");
//		System.out.println(trie.search("tenants"));
//		System.out.println(trie.startsWith("ten"));
//	}
//}
//
//
///**
// * Your Trie object will be instantiated and called as such:
// * Trie obj = new Trie();
// * obj.insert(word);
// * boolean param_2 = obj.search(word);
// * boolean param_3 = obj.startsWith(prefix);
// */