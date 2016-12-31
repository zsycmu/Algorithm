import Util.TreeNode;

/**
 * 
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author Shengyi
 *
 */

public class _226_Invert_Binary_Tree {
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
        	return null;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}
