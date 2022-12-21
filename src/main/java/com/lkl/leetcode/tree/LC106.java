package com.lkl.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likelong
 * @date 2022/12/21
 */
public class LC106 {

    /**
     * 哈希表快速查找，元素索引 用于查找中序数组中根节点索引下标
     */
    Map<Integer, Integer> map;

    /*
    整体步骤：
    1、第一步根据后序数组每次都能得到树的根节点
    2、得到根节点后，在中序数组中找到根节点下标索引，切割中序数组，该索引左边就是左子树节点，右边就是右子树节点
    3、然后根据左子树长度，可以从后序数组也切割出对应左子树节点和右子树节点
    4、在根据中序、后序数组对应左右子树节点递归得到对应左右孩子节点
    5、没有必要每次都创建新的数组在做处理，可以直接给出前后索引范围在原数组上直接切割处理，可以节省不少空间
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数下标遵循左闭右开原则
        if (inBegin >= inEnd || postBegin >= postEnd) {
            // 不满足条件，数组中没有元素直接返回
            return null;
        }
        // 后序数组最后一个元素是根节点元素
        // 从中序数组中得到根节点下标索引
        int rootIndex = map.get(postorder[postEnd - 1]);
        // 创建节点
        TreeNode root = new TreeNode(postorder[postEnd - 1]);

        // 保存中序左子树个数，用来确定后序数列的个数
        int lenOfLeft = rootIndex - inBegin;
        // 递归构建左右子树 中序左数组&后序左数组
        root.left = buildNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        // 中序右数组&后序右数组
        root.right = buildNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
        return root;
    }
}
