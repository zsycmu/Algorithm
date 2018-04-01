package Facebook;
//https://articles.leetcode.com/convert-binary-search-tree-bst-to/

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class _01_flatten_binary_tree {
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return root;
		}
		
		Node result = helper(root);
		Node tailNode = getTail(result);
		
		result.left = tailNode;
		tailNode.right = result;
		
		return result;
    }
	
	private Node helper(Node root) {
		if (root == null) {
			return null;
		}
		
        Node left = root.left;
        Node right = root.right;
        root.left = null;
        root.right = null;
        
		Node leftPart = helper(left);
		Node rightPart = helper(right);
		
		Node leftTail = getTail(leftPart);
        root.right = rightPart;
        
        if (rightPart != null) {
            rightPart.left = root;
        }
        
        if (leftPart == null) {
            return root;
        }
        
        leftTail.right = root;
        root.left = leftTail;

		return leftPart;
	}
	
	private Node getTail(Node root) {
		if (root == null) {
			return root;
		}
		
		Node index = root;
		
		while (index.right != null) {
			index = index.right;
		}
		
		return index;
	}
}
