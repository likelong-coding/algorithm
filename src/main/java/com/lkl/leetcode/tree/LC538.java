package com.lkl.leetcode.tree;

/**
 * @author likelong
 * @date 2022/12/28
 */
public class LC538 {

    int pre = 0;
    /**
     * 把二叉搜索树转换为累加树
     * 中序遍历二叉搜索树相当于遍历有序递增数组，从后往前数字相加
     * 反向中序遍历 右中左
     */
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        // 右
        convertBST(root.right);

        // 中
        root.val += pre;
        pre = root.val;

        // 左
        convertBST(root.left);

        return root;
    }
}
