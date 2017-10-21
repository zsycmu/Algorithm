import java.util.List;

import Util.TreeNode;

/**
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author shengyizhang
 *
 */

public class _145_Binary_Tree_Postorder_Traversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		
        if (root == null) {
        	return result;
        }
    }
}
