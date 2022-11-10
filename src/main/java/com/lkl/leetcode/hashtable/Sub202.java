package com.lkl.leetcode.hashtable;

/**
 * 快乐数
 * `然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1`
 * @author likelong
 * @date 2022/11/10
 */
public class Sub202 {
    public boolean isHappy(int n) {
//        if (n == 1 || n == 7) {
//            return true;
//        }
//
//        String num = String.valueOf(n);
//        int sum = 0;
//        for (int i = 0; i < num.length(); i++) {
//            sum += Math.pow(Integer.parseInt(num.charAt(i) + ""), 2);
//        }
//
//        num = sum + "";
//        while (String.valueOf(sum).length() != 1) {
//            sum = 0;
//            for (int i = 0; i < num.length(); i++) {
//                sum += Math.pow(Integer.parseInt(num.charAt(i) + ""), 2);
//            }
//            num = sum + "";
//        }
//        return sum == 1 || sum == 7;

        if(n == 1){
            return true;
        }

        //为什么会无限循环？ 找快乐数的过程找到了相同的数，相当于链表成环了，
        //因此，题目就演变成了判断链表是否成环
        /*
        以2为例： 2->4->16->37->58->89->145->42->20
                    |__________________________/
        所以链表只要成环了就会无限循环下去，此数就不是快乐数
        否则只要最后链表末尾元素值为1就是快乐数
         */
        //第一种：使用哈希表记录元素，再次出现相同元素说明链表成环 （哈希法）
//        List<Integer> cache = new ArrayList<>();
//        while(n != 1){
//            cache.add(n);
//            n = getNextNum(n);
//            if (cache.contains(n)){
//                return false;
//            }
//        }
//        return true;

        //第二种：双指针，fast、slow，fast指针一次移动两个节点，slow指针一次移动一个节点
        //fast指针要是能与slow相遇，说明链表成环（fast指针以一个节点的移动速度在环内追赶slow指针，最后一定会相遇）
        //否则链表不能成环
        int fast = n ,slow = 0;
        while(fast != slow){
            n = getNextNum(n);
            //指针向后移动一位
            slow = n;
            fast = getNextNum(fast);
            //指针向后移动两位
            fast = getNextNum(fast);
        }

        //快乐数fast = slow = 1，非快乐数 fast = slow != 1
        return fast == 1;
    }

    public int getNextNum(int n){
        int next = 0;
        while (n > 0){
            int num = n % 10;
            next += num * num;
            n /= 10;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Sub202().isHappy(19));
        System.out.println(new Sub202().isHappy(2));
    }
}
