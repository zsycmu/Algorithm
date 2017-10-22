package OA;

import java.util.Arrays;

import Util.TreeNode;

public class BST {
	public static int bstDistance(int[] values, int n, int node1, int node2) {
		if (values == null || values.length == 0) {
			return -1;
		}
		
		if (!Arrays.asList(values).contains(node1) || !Arrays.asList(values).contains(node2)) {
			return -1;
		}
		TreeNode root = generateTree(values);
		TreeNode LCA = findLCA(root, node1, node2);
//		int distNode1 = findDist(root, node1); 
//		int distNode2 = findDist(root, node2);
		int distNode1 = findDist(LCA, node1); 
		int distNode2 = findDist(LCA, node2);
		//int distLCA = findDist(root, LCA.val);
		
		//return distNode1 + distNode2 - 2 * distLCA;
		return distNode1 + distNode2;
	}
	private static TreeNode generateTree(int[] values) {
		TreeNode root = new TreeNode(values[0]);
		for (int i = 1; i < values.length; i++) {
			insertNode(root, values[i]);
		}
		return root;
	}
	private static void insertNode(TreeNode root, int val){
		if (root == null) {
			return;
		}
		if (root.left == null && val <= root.val) {
			root.left = new TreeNode(val);
			return;
		}
		
		if (root.right == null && val > root.val) {
			root.right = new TreeNode(val);
			return;
		}
		
		if (val <= root.val) {
			insertNode(root.left, val);
		} else {
			insertNode(root.right, val);
		}
	}
	
	private static int findDist(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		
		if (root.val == val) {
			return 0;
		} else if (root.val > val) {
			return findDist(root.left, val) + 1;
		} else {
			return findDist(root.right, val) + 1;
		}
	}
	
    public static TreeNode findLCA(TreeNode root, int val1, int val2) {
        if(root == null) {
        	System.out.println(3);
            return null; 
        }
        
        if(root.val > val1 && root.val > val2){
            return findLCA(root.left, val1, val2);
        }else if(root.val < val1 && root.val < val2){
            return findLCA(root.right, val1, val2);
        }else{
            return root;
        }    
    }
	 
	public static void main(String[] args) {

		 //int[] input = {5,6,3,1,2,4};

		 int[] input = {1};
		 TreeNode node = generateTree(input);

		 TreeNode lca = findLCA(node, 1, 1);


		 System.out.println(lca.val);



		 //System.out.println(getDistance(lca, 2));



		 //System.out.println(getDistance(lca, 6));



		 System.out.println(bstDistance(input, 6, 4, 9));

		 }
}
