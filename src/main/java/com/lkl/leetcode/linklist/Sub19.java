package com.lkl.leetcode.linklist;

import com.lkl.leetcode.linklist.node.ListNode;

/**
 * 删除倒数第n个节点元素
 * 核心在于找到目标节点前一个节点
 *
 * @author likelong
 * @date 2022/11/4
 */
public class Sub19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // 最坏要遍历两次链表
        // 第一次遍历获取链表长度，第二次遍历获取待删除节点前一个节点
        // 然后删除待删除节点
//        ListNode cur = head;
//        //链表节点个数
//        int length = 0;
//        while (cur != null) {
//            length++;
//            cur = cur.next;
//        }
//
//        int index = length - n;
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        //记录目标节点前一个节点
//        cur = dummyHead;
//        for (int i = 0; i < index ; i++) {
//             cur = cur.next;
//        }
//        //删除待删除节点
//        cur.next = cur.next.next;
//        return dummyHead.next;

        // 快慢双指针 遍历链表一次
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // fast + slow = 链表长度（length）
        // 首先指向 n + 1 位置节点
        ListNode fast = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        // 该指针记录待删除节点的前一个节点
        ListNode slow = dummyHead;
        // 当fast指针移动链表末尾，slow指针就指向待删除节点的前一个节点 length - (n + 1)
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除待删除节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        System.out.println(head);
        System.out.println(new Sub19().removeNthFromEnd(head, 1));
    }
}
