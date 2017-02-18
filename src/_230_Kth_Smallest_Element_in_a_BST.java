import Util.TreeNode;

/**
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * 
 * Hint:
 * 
 * Try to utilize the property of a BST.
 * What if you could modify the BST node's structure?
 * The optimal runtime complexity is O(height of BST).
 * @author Shengyi
 *
 */
// Note: -1
public class _230_Kth_Smallest_Element_in_a_BST {
	public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
        	return -1;
        }
        
        int leftSize = TreeSize(root.left);
        
        if (leftSize == k - 1) {
        	return root.val;
        } else if (leftSize > k - 1) {
        	return kthSmallest(root.left, k);
        } else {
        	return kthSmallest(root.right, k - leftSize - 1); // Minutes 1 is for the root
        }
    }
	
	private int TreeSize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return TreeSize(root.left) + TreeSize(root.right) + 1;
	}
}
