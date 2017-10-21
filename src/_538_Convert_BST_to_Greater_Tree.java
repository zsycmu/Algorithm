import Util.TreeNode;

/**
 * 
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 * 
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * @author shengyizhang
 *
 */
// Note: do it again.

public class _538_Convert_BST_to_Greater_Tree {
	int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        helper(root);
        
        return root;
    }
    
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
