package com.lkl.leetcode.tree;

/**
 * @author likelong
 * @date 2022/12/27
 */
public class LC108 {

    /**
     * 将有序数组转换为二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length);
    }

    /**
     * 构建树
     * @param nums 原数组
     * @param start 开始索引
     * @param end 结束索引
     */
    public TreeNode buildNode(int[] nums, int start, int end) {
        if (start >= end) {
            // 递归终止条件
            return null;
        }
        // 根节点
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        // 左子树
        root.left = buildNode(nums, start, middle);
        // 右子树
        root.right = buildNode(nums, middle + 1, end);
        return root;
    }
}
