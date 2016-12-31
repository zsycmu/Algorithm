import Util.TreeNode;

/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author Shengyi
 *
 */

public class _112_Path_Sum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
        	return false;
        }
        
        return helper(root, 0, sum);
    }
	
	public boolean helper(TreeNode root, int sum, int target) {
		if (root == null) {
	        return false;
	    }
		
		sum = root.val + sum;
		
		if (root.left == null && root.right == null && sum == target) {
			return true;
		}
		
		return helper(root.left, sum, target) || helper(root.right, sum, target);
	}
}
