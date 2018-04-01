import Util.TreeNode;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * 
 * The whole input represents a binary tree. It contains an integer followed by zero, 
 * one or two pairs of parenthesis. The integer represents the root's value and a pair 
 * of parenthesis contains a child binary tree with the same structure.
 * 
 * You always start to construct the left child node of the parent first if it exists.
 * 
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * 
 *        4
 *      /   \
 *     2     6
 *    / \   / 
 *   3   1 5   
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 * @author Shengyi
 *
 */

public class _536_Construct_Binary_Tree_from_String {
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        int start = 0;
        int end = 0;
        int value = 0;
        boolean positive = true;
        
        if (s.charAt(end) == '-') {
            positive = false;
            start++;
            end++;
        }
        
        while (end < s.length() && s.charAt(end) != '(') {
            value = value * 10 + (s.charAt(end) - '0');
            start++;
            end++;
        }
        
        value = positive ? value : -1 * value;
        
        TreeNode node = new TreeNode(value);
        int countLeft = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            end++;
            if (c == '(') {
                countLeft++;
            } else if (c == ')') {
                countLeft--;
            } else {
                continue;
            }
            
            if (countLeft == 0) {
                break;
            }
        }
        
        if (start < s.length() - 1) {
            node.left = str2tree(s.substring(start + 1, end - 1));
        }
        
        if (end < s.length()) {
            node.right = str2tree(s.substring(end + 1, s.length() - 1));
        }
        
        return node;
    }
	
	public static void main(String[] args) {
		String test = "";
		String test2 = "1";
		String test3 = "-1";
		String test4 = "4(2(3)(1))(6(5))";
		String test5 = "-4(2(3)(1))(6(5))";
		String test6 = "40(20(30)(10))(60(50))";
	}
}
