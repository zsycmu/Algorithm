import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author Shengyi
 *
 */

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
        	return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean order = true;
        
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> list = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++) {
        		TreeNode temp = queue.poll();
        		if (order) {
        			list.add(temp.val);
        		} else {
        			list.add(0, temp.val);
        		}
            	
            	
            	if (temp.left != null) {
            		queue.offer(temp.left);
            	}
            	
            	if (temp.right != null) {
            		queue.offer(temp.right);
            	}
        	}
        	order = order ? false : true;
        	result.add(list);
        }
        
        return result;
    }
}
