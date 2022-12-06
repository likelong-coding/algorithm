package com.lkl.leetcode.tree.deepth;

import com.lkl.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 * @author likelong
 * @date 2022/12/6
 */
public class Post {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                root = root.right;
            }

            TreeNode node = stack.pop();
            root = node.left;
        }

        //根右左 然后反转结果
        Collections.reverse(ans);
        return ans;
    }
}
