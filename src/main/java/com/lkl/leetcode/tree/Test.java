package com.lkl.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author likelong
 * @date 2022/12/7
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void testQueue(){
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        root.left = left;
        root.right = right;

        System.out.println(connect(root));
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                node.next = queue.peek();

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}
