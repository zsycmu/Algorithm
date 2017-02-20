import Util.TreeNode;

/**
 * 
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * @author Shengyi
 *
 */
// Note: Just know how to think about it. Implementation is not hard.

public class _222_Count_Complete_Tree_Nodes {
	public int countNodes(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        int leftHight = getLeftHight(root.left);
        int rightHight = getRightHight(root.right);
        
        if (leftHight == rightHight) {
        	return (2 << leftHight) - 1;
        } else {
        	return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
	
	private int getLeftHight(TreeNode node) {
		int result = 0;
		
		while (node != null) {
			result++;
			node = node.left;
		}
		
		return result;
	}
	
	private int getRightHight(TreeNode node) {
		int result = 0;
		
		while (node != null) {
			result++;
			node = node.right;
		}
		
		return result;
	}
}
