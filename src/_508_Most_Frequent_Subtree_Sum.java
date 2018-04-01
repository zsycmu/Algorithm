import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.TreeNode;

/**
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * 
 * Examples 1
 * Input:
 * 
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * 
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * @author Shengyi
 *
 */

public class _508_Most_Frequent_Subtree_Sum {
	private int currentMaxcount = 0;
    private int currentMaxSum = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        
        Map<Integer, List<TreeNode>> nodeMap = new HashMap<Integer, List<TreeNode>>();
        
        helper(root, nodeMap);
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (Integer i : nodeMap.keySet()) {
            if (nodeMap.get(i).size() == currentMaxcount) {
                result.add(i);
            }
        }
        
        int[] resultArray = new int[result.size()];
        
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
    
    private int helper(TreeNode root, Map<Integer, List<TreeNode>> nodeMap) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left, nodeMap);
        int right = helper(root.right, nodeMap);
        
        int current = root.val + left + right;
        List<TreeNode> list = null;
        
        if (nodeMap.containsKey(current)) {
            list = nodeMap.get(current);
        } else {
            list = new ArrayList<TreeNode>();
        }
        
        list.add(root);
        nodeMap.put(current, list);
        
        if (list.size() > currentMaxcount) {
            currentMaxcount = list.size();
            currentMaxSum = current;
        }
        
        return current;
    }
}
