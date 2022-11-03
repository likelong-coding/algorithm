package com.lkl.linklist;

/**
 * 链表类中实现下面方法
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
class MyLinkedList {

    /**
     * 虚拟头节点
     */
    MyNode dummyHead;

    /**
     * 尾节点
     */
    MyNode tail;

    /**
     * 记录链表中元素个数
     */
    int count;

    static class MyNode {
        int val;
        MyNode next;

        public MyNode(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        //初始化虚拟头节点
        dummyHead = new MyNode(-1);
        count = 0;
    }

    public int get(int index) {
        if (index < 0 || index > count - 1) {
            return -1;
        }
        return getNode(index).val;
    }

    /**
     * 头插
     */
    public void addAtHead(int val) {
        MyNode cur = dummyHead;
        MyNode node = new MyNode(val);
        //除虚拟头节点无其他节点
        if (cur.next == null) {
            cur.next = node;
            tail = node;
        } else {
            //记录真正头节点
            MyNode next = cur.next;
            cur.next = node;
            node.next = next;
        }
        count++;
    }

    /**
     * 尾接
     */
    public void addAtTail(int val) {
        MyNode cur = dummyHead;
        MyNode node = new MyNode(val);
        if (tail == null) {
            cur.next = node;
        } else {
            tail.next = node;
        }
        tail = node;
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == count) {
            addAtTail(val);
            return;
        }
        if (index > count) {
            // do nothing
            return;
        }
        MyNode prev = getNode(index - 1);
        MyNode cur = getNode(index);
        MyNode target = new MyNode(val);
        prev.next = target;
        target.next = cur;
        count++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > count - 1) {
            return;
        }
        //删除头节点
        if (index == 0) {
            dummyHead.next = dummyHead.next.next;
        }
        //删除尾节点
        else if (index == count - 1) {
            //前一个节点
            MyNode prev = getNode(index - 1);
            prev.next = null;
            tail = prev;
        } else {
            //前一个节点
            MyNode prev = getNode(index - 1);
            //当前节点
            MyNode cur = prev.next;
            //后一个节点
            prev.next = cur.next;
        }
        count--;
    }

    /**
     * 获取链表对应节点元素
     *
     * @param index 确保下标在合理范围内 [0, count - 1]
     * @return 节点元素
     */
    public MyNode getNode(int index) {

        MyNode ans = null;
        //从真实头节点开始遍历
        MyNode cur = dummyHead.next;
        for (int i = 0; i <= index; i++) {
            ans = cur;
            cur = cur.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);

        System.out.println(myLinkedList.count);
        System.out.println(myLinkedList.get(0));
    }

}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
