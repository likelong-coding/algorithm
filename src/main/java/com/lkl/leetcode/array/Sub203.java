package com.lkl.leetcode.array;

/**
 * @author likelong
 * @date 2022/11/1
 */
public class Sub203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //   //第一种：统一规则，删除节点，定义一个虚拟头节点
        //   ListNode dummyHead = new ListNode(-1);
        //   dummyHead.next = head;

        //   //遍历链表
        //   ListNode node = dummyHead;
        //   while(node.next != null){
        //       if(node.next.val == val){
        //        //当前节点的next指向当前节点的next.next
        //        node.next = node.next.next;
        //       }else{
        //       node = node.next;
        //       }
        //   }

        //   return dummyHead.next;

        //第二种：头节点删除方式和其他节点不太一样，区分开来
        //删除头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        //其余节点
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}

class ListNode {
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
