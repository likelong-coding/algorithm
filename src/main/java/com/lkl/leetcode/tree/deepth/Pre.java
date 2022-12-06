package com.lkl.leetcode.tree.deepth;

import com.lkl.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 * @author likelong
 * @date 2022/12/6
 */
public class Pre {
    public List<Integer> preorderTraversal(TreeNode root) {
        //迭代法
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            root = node.right;
        }

        return ans;
    }
}
