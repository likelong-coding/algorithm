package com.lkl.leetcode.linklist;

import com.lkl.leetcode.linklist.node.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author likelong
 * @date 2022/11/4
 */
public class Sub24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //搞一个虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        //虚拟头节点next指向真实头节点
        dummyHead.next = head;
        //从虚拟头节点开始遍历
        ListNode prev = dummyHead;
        while (prev != null && prev.next != null) {
            ListNode cur = prev.next;
            ListNode next = cur.next;
            //奇数个节点，到最后一个节点直接结束不做交换
            if (next == null) {
                break;
            }
            //记录第二个节点的下一个节点
            ListNode nextNext = next.next;
            //节点交换位置
            next.next = cur;
            cur.next = nextNext;
            prev.next = next;
            //向后移两位
            prev = prev.next.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        node2.next = new ListNode(4);

        System.out.println(new Sub24().swapPairs(head));


    }
}
