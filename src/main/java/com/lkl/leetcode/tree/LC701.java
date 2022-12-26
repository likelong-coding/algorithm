package com.lkl.leetcode.tree;

/**
 * @author likelong
 * @date 2022/12/26
 */
public class LC701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // 缓存上一个节点
        TreeNode pre;
        // 遍历树
        TreeNode temp = root;
        while (true) {
            pre = temp;
            if (val > temp.val) {
                temp = temp.right;
                if (temp == null) {
                    pre.right = new TreeNode(val);
                    break;
                }
            } else {
                temp = temp.left;
                if (temp == null) {
                    pre.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}
