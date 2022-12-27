package com.lkl.leetcode.tree;

/**
 * 删除二叉树节点
 * @author likelong
 * @date 2022/12/27
 */
public class LC450 {

    /**
     *  五种情况：删除目标节点，返回节点
     *  1、没有目标节点直接返回null
     *  2、有目标节点
     *     ① 叶子节点，左右都为空，直接返回null，相当于删除该叶子节点
     *     ② 左不空右空，返回左
     *     ③ 左空右不空，返回右
     *     ④ 左右都不空，找到目标节点右子树最小值节点，将目标节点左子树挂到该节点，然后返回目标节点右子树
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 1、
        if(root == null) {
            return null;
        }
        // 2、
        if(root.val == key){
            // ①
            if(root.left == null && root.right == null){
                return null;
                // ②
            }else if(root.left != null && root.right == null){
                return root.left;
                // ③
            }else if(root.left == null && root.right != null){
                return root.right;
            }else {
                // ④
                TreeNode cur = root.right;
                while (cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
