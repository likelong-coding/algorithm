package com.lkl.leetcode.greedy;

/**
 * 134. 加油站
 *
 * @author likelong
 * @date 2023/1/10
 */
public class LC134 {


    /*
    油就这么多油，总油量大于等于耗油量才能绕一圈
    rest[i] = gas[i] - cost[i]
    totalRest 总共剩余油量

    当一个加油站油量小于到达下一个加油站油量，跳过该加油站
    连续多个加油站等同于一个加油站，相当于剩余油量小于零，跳过这些加油站，剩余油量清零重新计算
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 加油站开始索引
        int startIndex = 0;
        // 到当前加油站所剩余油量
        int curRest = 0;
        // 总剩余油量
        int totalRest = 0;
        for (int i = 0; i < gas.length; i++) {
            curRest += gas[i] - cost[i];
            totalRest += gas[i] - cost[i];

            // 连续多个加油站剩余油量小于0，说明到不了下一个加油站，直接跳到下一个加油站
            if(curRest < 0){
                startIndex = i + 1;
                // 剩余油量恢复到初始值，重新开始计算
                curRest = 0;
            }
        }
        return totalRest < 0 ? -1 : startIndex;
    }
}
