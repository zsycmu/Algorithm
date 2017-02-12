import Util.TreeNode;

/**
 * 
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * @author shengyizhang
 *
 */
//Note: 这个题直接重新做吧。。。
//https://segmentfault.com/a/1190000007533582
public class _437_Path_Sum_III {
	public int pathSum(TreeNode root, int sum) {
        if (root == null) {
        	return 0;
        }
        
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
	
	private int helper(TreeNode root, int sum) {
		int value = 0;
		
		if (root == null) {
			return value;
		}
		
		if (sum == root.val) {
			value++;
		}
		
		value += helper(root.left, sum - root.val);
		value += helper(root.right, sum - root.val);
		
		return value;
	}
}
