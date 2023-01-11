package com.lkl.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 *
 * @author likelong
 * @date 2023/1/11
 */
public class LC406 {

    /*
      对于数对排序问题
     一般是先按key1正序、key2逆序，或者key1逆序、key2正序的方式，先进行一轮排序，以简化解题过程
     */

    public int[][] reconstructQueue(int[][] people) {
        // 最后返回队列，高的人先进队列
        List<int[]> queue = new LinkedList<>();
        // people 进行排序 按身高降序，身高相同按 k 升序
        // 按身高降序保证当前元素之前都是比他高的；k 升序 保证按 k 从小到大插入 k值大的一定在后面
        Arrays.sort(people, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        }));


        for (int[] person : people) {
            // 往队列中插入元素，由于已经按身高排过序，直接按 k 对应 值插入即可，前面必定是身高大于等于他的人
            queue.add(person[1], person);
        }

        // finally, list to array
        return queue.toArray(new int[0][0]);
    }
}
