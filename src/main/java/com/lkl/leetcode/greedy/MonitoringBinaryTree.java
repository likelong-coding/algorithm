package com.lkl.leetcode.greedy;

import com.lkl.leetcode.tree.TreeNode;

/**
 * 968. 监控二叉树
 *
 * @author likelong
 * @date 2023/1/16
 */
public class MonitoringBinaryTree {

    int count = 0;

    public int minCameraCover(TreeNode root) {
        // 最后根节点可能是无覆盖状态，无覆盖根节点 则根节点放置一个摄像头
        if (dfs(root) == 0) {
            count++;
        }
        return count;
    }

    /**
     * 后续遍历，从下往上传递节点状态
     * 节点有三种状态：
     * > 0：节点无覆盖
     * > 1：节点有摄像头
     * > 2：节点有覆盖
     * 保证叶子节点父节点放置摄像头，使得有最小摄像头
     */
    public int dfs(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            // 叶子节点应该是有覆盖状态，避免叶子节点防止摄像头
            return 2;
        }

        // 后序遍历
        // 左
        int left = dfs(root.left);
        // 右
        int right = dfs(root.right);

        // 根，根据左右节点状态信息，返回当前节点状态信息
        if (left == 2 && right == 2) {
            // (2,2) 左右节点都有覆盖，说明该节点就该是无覆盖、无摄像头状态
            return 0;
        } else if (left == 0 || right == 0) {
            // 左右节点有无覆盖状态，那 根节点 此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            count++;
            return 1;
        } else {
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 说明本节点就是处于被覆盖状态
            return 2;
        }
    }
}
