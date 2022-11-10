package com.lkl.leetcode.hashtable;

/**
 * 快乐数
 *
 * @author likelong
 * @date 2022/11/10
 */
public class Sub202 {
    public boolean isHappy(int n) {
        if (n == 1 || n == 7) {
            return true;
        }

        String num = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += Math.pow(Integer.parseInt(num.charAt(i) + ""), 2);
        }

        num = sum + "";
        while (String.valueOf(sum).length() != 1) {
            sum = 0;
            for (int i = 0; i < num.length(); i++) {
                sum += Math.pow(Integer.parseInt(num.charAt(i) + ""), 2);
            }
            num = sum + "";
        }
        return sum == 1 || sum == 7;
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
        System.out.println(new Sub202().isHappy(1111111));
        System.out.println(new Sub202().isHappy(2));

        System.out.println(new Sub202().getNextNum(13));
    }
}
