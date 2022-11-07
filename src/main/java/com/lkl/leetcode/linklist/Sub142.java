package com.lkl.leetcode.linklist;

import com.lkl.leetcode.linklist.node.ListNode;

/**
 * 环形链表
 *
 * @author likelong
 * @date 2022/11/6
 */
public class Sub142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        //借助额外空间，空间复杂度O(n)
//        List<ListNode> list = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null) {
//            //成环
//            if (list.contains(cur)) {
//                return cur;
//            }
//            list.add(cur);
//            cur = cur.next;
//        }
//        //未成环
//        return null;

        //首先判断链表是否成环，快慢双指针
        //每次向后移动两个节点
        ListNode fast = head;
        //每次向后移动一个节点
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //在环内相遇了，相遇节点
            if (fast == slow) {
                //将快指针指向头节点
                fast = head;
                //此时两个指针从头节点和相遇节点同时以一个节点的速度移动，
                //一定会在环入口相遇
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                //环入口节点
                return fast;
            }
        }

        //链表未成环
        return null;
    }
}
