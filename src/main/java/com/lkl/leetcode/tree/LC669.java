package com.lkl.leetcode.tree;

/**
 * 修剪二叉树，删除二叉树节点升级版，思想基本不变，五种情况都要考虑
 * 可见 LC450.
 * @author likelong
 * @date 2022/12/27
 */
public class LC669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // 返回删除节点之后的节点
        if(root.val < low || root.val > high){
            if(root.left == null && root.right == null){
                // 叶子节点
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.left == null && root.right != null){
                return root.right;
            }else{
                // 找到待删除节点右子树最小值节点，该节点指向待删除节点左子树
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }

        return root;
    }

}
