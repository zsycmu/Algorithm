import Util.TreeNode;

/**
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author Shengyi
 *
 */

public class _111_Minimum_Depth_of_Binary_Tree {
	//This is an important one, need redo
	public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        return getHeight(root);
    }
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		return Math.min(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
