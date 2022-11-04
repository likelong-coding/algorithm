package com.lkl.leetcode.linklist;

/**
 * @author likelong
 * @date 2022/11/4
 */
public class Sub206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        //链表为空或者链表只有一个节点，直接返回该链表
        if (head == null || head.next == null) {
            return head;
        }
        //迭代
        //该指针用来遍历链表
        ListNode cur = head;
        //头插法一次遍历
        ListNode ans = null;
        while (cur != null) {
            //记录当前节点的下一个节点 顺序遍历链表
            ListNode next = cur.next;
            //头插法
            cur.next = ans;
            ans = cur;
            cur = next;
        }
        return ans;

        //递归
        // //指针反向 head.next有种遍历链表的意思
        // ListNode ans = reverseList(head.next);
        // head.next.next = head;
        // //目的就是为了将链尾节点next置为null，防止链表成环死循环
        // head.next = null;
        // return ans;
    }
}
