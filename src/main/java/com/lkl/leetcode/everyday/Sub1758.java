package com.lkl.leetcode.everyday;

/**
 * @author likelong
 * @date 2022/11/29
 */
public class Sub1758 {
    public int minOperations(String s) {
        // char[] ch = s.toCharArray();
        // //字符串开头无非就是'0'或者'1'
        // if(ch[0] == '0'){
        //     ch[0] = '1';
        // }else{
        //     ch[0] = '0';
        // }
        // //比较找出最小操作数
        // return Math.min(getOperationNum(s.toCharArray()),getOperationNum(ch) + 1);

        //字符串开头无非就是'0'或者'1' 两种情况操作数之和为字符串长度
        int operationNum = getOperationNum(s.toCharArray());
        //比较找出最小操作数
        return Math.min(operationNum, s.length() - operationNum);
    }

    public int getOperationNum(char[] ch) {
        int ans = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] != ch[i + 1]) {
                continue;
            }

            ans++;
            //    if(ch[i + 1] == '0'){
            //        ch[i + 1] = '1';
            //    }else{
            //        ch[i + 1] = '0';
            //    }

            //同上
            ch[i + 1] ^= 1;
        }

        return ans;
    }
}
