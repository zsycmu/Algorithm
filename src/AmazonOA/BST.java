package AmazonOA;

import Util.TreeNode;

/**
 * 
 * 第二題BST find 2 nodes distance
 * 
 * *
 * 
 * BST是给一个无序数组，以第一个数为根建BST，然后再给两个整数（不一定在数组里），去算两个数的最短距离。我的解法应该也挺暴力的，用插入法建BST，然后找两个点的祖先，从祖先开始招较小数离祖先的路径长与较大数与祖先的路径长，加起来就是啦~然后要注意NPE的问题。
 * 我一开始第二个testcase就没过……然后处理了NPE的问题后，一下就全过了……所以也没考虑太多
 * 
 * 
 * 这个是主函数
public static int bstdistance(int[] values, int n, int node1, int node2) {.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
                // create the tree use values array and n
                if(values == null || values.length == 0) return 0;
                TreeNode root = new TreeNode(values[0]);
                for(int i = 1; i < values.length; i++) {
                        createbst(root, values);.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
                }
                //TreeNode root = createbst(values); // this is a func
                int len1 = findlen(root, node1);.1point3acres缃�
                //int len1 = finddepth(root, node1);-google 1point3acres
                if(len1==-1) return 0; // means this node no exist inside this tree-google 1point3acres
                int len2 = findlen(root, node2);
                //int len2 = finddepth(root, node2);
                if(len2==-1) return 0;
                int lcaval = LCABST1(root, node1, node2).val;
                int lenmid = findlen(root, lcaval);-google 1point3acres
                //int lenmid = finddepth(root, lcaval);
                return len1+len2-2*lenmid;. Waral 鍗氬鏈夋洿澶氭枃绔�,
        }

这个是通过输入的数建立BST的过程
public static void createbst(TreeNode root, int value) {
                if(value < root.val) {
                        if(root.left == null) {
                                root.left = new TreeNode(value);
                        } else {. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
                                createbst(root.left, value);
                        }.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
                } else {
                        if(root.right == null) {
                                root.right = new TreeNode(value);
                        } else {
                                createbst(root.right, value);
                        }. more info on 1point3acres.com
                }
        }
. 1point 3acres 璁哄潧
// 这个是寻找两个点的公共祖先
public static TreeNode LCABST1(TreeNode root, int i1, int i2) {
                if(root == null || i1 == root.val || i2 == root.val) return root;
                if((root.val > i1 && root.val < i2) ||
                                (root.val < i1 && root.val > i2)) {
                        return root;. 1point 3acres 璁哄潧
                } else if(root.val > i1 && root.val > i2) {
                        return LCABST1(root.left, i1, i2);
                } else if(root.val < i1 && root.val < i2) {
                        return LCABST1(root.right, i1, i2);
                } else {. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
                        return null;
                }
        }
下面这个是从root到指定点的距离
public static int findlen(TreeNode root, int n) {
                return finddistancebst(root, n)-1;
        }. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
        public static int finddistancebst(TreeNode root, int n) {
                if(root == null) return 0;
                int x = 0;.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
                if(root.val == n) return x+1;
                if(root.val > n) {
                        x = finddistancebst(root.left, n);
                } else {
                        x = finddistancebst(root.right, n);
                } 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
                if(x > 0)
                        return x+1;
                else return 0;. From 1point 3acres bbs
        }
        
        
        ****
        *
        *construct BST 后找俩node之间distance

Given a list of unique integers, construct the binary tree by given order without rebalancing, then find out the distance between two nodes.. 鍥磋鎴戜滑@1point 3 acres



public static int bstDistance(int[] values, int n, int node1, int node2)
. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
for example,
.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
values= [5,6,3,1,2,4], n is the size of values, node1 is 2, node2 is 4, then function return 3
构建完BST如下，2和4呢，距离就是3
      5
   3      6
1   4

  2.
        
 * @author Shengyi
 *
 */

public class BST {
	public static int bstDistance(int[] values, int n, int node1, int node2) {
		if (values == null || values.length == 0) {
			return 0;
		}
		
		TreeNode root = values[0];
		for (int i = 1; i < values.length; i++) {
			create(root, values[i]);
		}
	}
	
	private void create(TreeNode root, int val){
		
	}
}
