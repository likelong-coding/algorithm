package com.lkl.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中的众数
 *
 * @author likelong
 * @date 2022/12/23
 */
public class LC501 {

    /*
     1、中序遍历二叉搜索树等于遍历有序数组
     2、迭代法借助栈
     3、双指针法，一次遍历，记录每个元素出现次数（count），记录出现频率最高的次数（maxCount），前一个节点pre以及记录结果
     */

    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 记录结果
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int maxCount = 0;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                // 左
                root = root.left;
            }

            // 根
            root = stack.pop();
            if(pre == null || pre.val != root.val){
                count = 1;
            }else {
                count++;
            }
            pre = root;

            // 记录结果
            if(count == maxCount){
                ans.add(root.val);
            }else if(count > maxCount){
                // 更新结果
                maxCount = count;
                ans.clear();
                ans.add(root.val);
            }

            // 右
            root = root.right;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
