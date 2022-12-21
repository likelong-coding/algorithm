package com.lkl.leetcode.tree;

/**
 * 验证二叉搜索树，二叉搜索树中序遍历，节点值依次递增
 * @author likelong
 * @date 2022/12/21
 */
public class LC98 {

    /**
     * 前一个节点
     */
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        // 中序遍历
        // 左节点
        boolean left = isValidBST(root.left);
        // 根节点
        if(pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        // 右节点
        boolean right = isValidBST(root.right);

        // 左右子树都满足条件返回true
        return left && right;
    }
}
