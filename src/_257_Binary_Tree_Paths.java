import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 * @author Shengyi
 *
 */

public class _257_Binary_Tree_Paths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        
        if (root == null) {
        	return result;
        }
        
        List<Integer> temp = new ArrayList<Integer>();
        
        helper(root, result, temp);
        
        return result;
    }
	
	public void helper(TreeNode root, List<String> result, List<Integer> temp) {
		if (root == null) {
			return;
		}
		
		temp.add(root.val);
		
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			for (int i : temp) {
				sb.append(i);
				sb.append("->");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
			
			result.add(sb.toString());
		}
		
		if (root.left != null) {
			helper(root.left, result, temp);
			temp.remove(temp.size() - 1);
		}
		
		if (root.right != null) {
			helper(root.right, result, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
