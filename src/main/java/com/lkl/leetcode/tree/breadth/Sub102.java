package com.lkl.leetcode.tree.breadth;

import com.lkl.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 广度优先搜索——层序遍历
 *
 * @author likelong
 * @date 2022/12/6
 */
public class Sub102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //记录每一层节点个数
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);

                //将该节点的左右节点放入队列
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans.add(temp);
        }

        return ans;
    }


}
