package com.lkl.leetcode.linklist;

import com.lkl.leetcode.linklist.node.ListNode;

import java.util.Stack;

/**
 * @author likelong
 * @date 2022/11/5
 */
public class Sub160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //我的做法，我甚至感觉我的做法才是对的
//        ListNode reverseA = reverse(headA);
//        ListNode reverseB = reverse(headB);
//        if (reverseA.val != reverseB.val) {
//            return null;
//        }
//
//        ListNode ans = null;
//        while (reverseA != null && reverseB != null) {
//            if (reverseA.val == reverseB.val) {
//                ans = reverseA;
//            } else {
//                break;
//            }
//            reverseA = reverseA.next;
//            reverseB = reverseB.next;
//        }
//        return ans;

        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }

    public ListNode reverse(ListNode head) {
//        ListNode cur = head;
//        ListNode ans = null;
//
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = ans;
//            ans = cur;
//            cur = next;
//        }
//        return ans;

        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        ListNode ans = new ListNode(stack.pop());
        cur = ans;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;

        ListNode headB = new ListNode(2);
        ListNode node12 = new ListNode(1);
        headB.next = node12;
        ListNode node22 = new ListNode(3);
        node12.next = node22;

        System.out.println(new Sub160().getIntersectionNode(head, headB));

    }
}
