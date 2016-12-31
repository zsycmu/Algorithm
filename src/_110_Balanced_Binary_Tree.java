import Util.TreeNode;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author Shengyi
 *
 */

public class _110_Balanced_Binary_Tree {
	//Need to investigate again
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
        	return true;
        }
        
        return helper(root) != -1;
    }
	
	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = helper(root.left);
		int rightHeight = helper(root.right);
		
		int diff = Math.abs(leftHeight - rightHeight);
		
		if (diff > 1 || leftHeight == -1 || rightHeight == -1) {
			return -1;
		} else {
			return Math.max(helper(root.left), helper(root.right)) + 1;
		}
	}
}
