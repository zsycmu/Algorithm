package NewSolution;

import Util.ListNode;
import Util.TreeNode;

public class Solution1 {
	public static void main(String[] args) {
		String stringTest = "";
		String[] stringArrayTest = {"", ""};
		
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		
		TreeNode treeNode = new TreeNode(2);
		treeNode.left = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		
		
		System.out.println("");
	}
}
