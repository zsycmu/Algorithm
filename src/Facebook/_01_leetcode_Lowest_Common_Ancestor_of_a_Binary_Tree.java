package Facebook;

import Util.TreeNode;

public class _01_leetcode_Lowest_Common_Ancestor_of_a_Binary_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
        	return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
        	return root;
        } else if (left != null) {
        	return left;
        } else if (right != null) {
        	return right;
        } else {
        	return null;
        }
    }
}
