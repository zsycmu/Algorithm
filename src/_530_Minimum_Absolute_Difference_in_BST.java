import Util.TreeNode;

/**
 * 
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * Input:
 * 
 *    1
 *     \
 *      3
 *     /
 *    2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 * @author shengyizhang
 *
 */
// http://www.cnblogs.com/grandyang/p/6540165.html
public class _530_Minimum_Absolute_Difference_in_BST {
	int result = Integer.MAX_VALUE;
	
	public int getMinimumDifference(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return result;
    }
	
	public void helper(TreeNode root, int min, int max) {
		if (root == null) {
			return;
		}
		
		if (min != Integer.MIN_VALUE) {
			result = Math.min(result, root.val - min);
		}
		
		if (max != Integer.MAX_VALUE) {
			result = Math.min(result, max - root.val);
		}
		
		helper(root.left, min, root.val);
		helper(root.right, root.val, max);
	}
}
