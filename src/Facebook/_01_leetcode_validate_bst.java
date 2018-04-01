package Facebook;

import Util.TreeNode;

/**
 * 
 * 判断BST，follow up是还可以用什么方法
 * @author Shengyi
 *
 */

public class _01_leetcode_validate_bst {
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    
    private boolean helper(long min, long max, TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        return helper(min, root.val, root.left) && helper(root.val, max, root.right);
    }
}
