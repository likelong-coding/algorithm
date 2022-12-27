package com.lkl.leetcode.tree;

/**
 * @author likelong
 * @date 2022/12/27
 */
public class LC235 {

    /**
     * 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 递归
/*        if(root.val > p.val && root.val > q.val){
            // 左子树查找
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            // 向右子树查找
            return lowestCommonAncestor(root.right, p, q);
        }else{
            // 直接返回结果
            return root;
        }*/

        // 迭代
        while (root != null) {
            // 当前节点值大于两个目标节点值，向左子树查找
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
                // 当前节点值小于两个目标节点值，向右子树查找
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                // 否则当前节点在两个目标节点之间，直接返回结果
                return root;
            }
        }
        return null;
    }
}
