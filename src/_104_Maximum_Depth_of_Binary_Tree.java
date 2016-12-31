import Util.TreeNode;

/**
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author Shengyi
 *
 */

public class _104_Maximum_Depth_of_Binary_Tree {
	public int maxDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
