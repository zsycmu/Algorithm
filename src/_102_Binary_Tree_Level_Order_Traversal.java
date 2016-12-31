import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author Shengyi
 *
 */

public class _102_Binary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
        	return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> list = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++) {
        		TreeNode temp = queue.poll();
            	list.add(temp.val);
            	
            	if (temp.left != null) {
            		queue.offer(temp.left);
            	}
            	
            	if (temp.right != null) {
            		queue.offer(temp.right);
            	}
        	}
        	result.add(list);
        }
        
        return result;
    }
}
