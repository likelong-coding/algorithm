package com.lkl.leetcode.linklist;

/**
 * @author likelong
 * @date 2022/11/9
 */
public class Offer2_35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    ", random=" + random +
                    '}';
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // //时间复杂度空间复杂度均为O(n)
        // //遍历链表
        // Node cur = head;
        // //key是当前节点，value是当前节点对应的新的节点
        // Map<Node, Node> map = new HashMap<>();
        // while(cur != null){
        //     map.put(cur, new Node(cur.val));
        //     cur = cur.next;
        // }

        // cur = head;
        // //填充新链表中节点next和random指针指向
        // while(cur != null){
        //     map.get(cur).next = map.get(cur.next);
        //     map.get(cur).random = map.get(cur.random);
        //     cur = cur.next;
        // }

        // //返回新链表头节点
        // return map.get(head);

        //新的做法
        //1、复制新节点，放在对应原节点的后面 如：1 -> 1`-> 2 -> 2`
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node copy = new Node(cur.val);
            copy.next = next;
            cur.next = copy;
            cur = next;
        }
        //2、填充复制节点random指向
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            //指向原节点对应的新复制的节点 random指针可能为null
            if (cur.random != null) {
                copy.random = cur.random.next;
            }
            //原节点
            cur = cur.next.next;
        }
        //3、将链表拆分，此时复制节点的next指针就得以填充，需要将原链表恢复原样 1 -> 2 / 1` -> 2`
        //定义一个虚拟头节点
        Node dummyHead = new Node(-1);
        cur = head;
        Node cur1 = dummyHead;
        while (cur != null) {
            Node copy = cur.next;
            Node next = cur.next.next;
            cur.next = next;
            cur1.next = copy;
            cur = next;
            cur1 = cur1.next;
        }

        return dummyHead.next;
    }

    /**
     * 拆分链表
     *
     * @param head 链表头节点
     */
    public Node split(Node head) {
        Node dummyHead = new Node(-1);
        Node cur = head;
        Node cur1 = dummyHead;
        while (cur != null) {
            cur1.next = cur.next;
            cur = cur.next.next;
            cur1 = cur1.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        head.next = node1;
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;
        System.out.println(new Offer2_35().split(head));
    }
}
