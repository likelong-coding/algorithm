package com.lkl.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likelong
 * @date 2022/10/24
 */
public class Sub904 {

    public int totalFruit(int[] fruits) {
        // key：水果种类 value：对应水果数量
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        // i起始位置，j终止位置，c 水果种类
        for (int i = 0, j = 0, c = 0; j < fruits.length; j++) {
            if (!map.containsKey(fruits[j])) {
                map.put(fruits[j], 1);
                c++;
            } else {
                map.put(fruits[j], map.get(fruits[j]) + 1);
            }

            //水果种类大于2，移动起始位置 （滑动窗口）
            while (map.keySet().size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);

                //该类水果为0，移除该类水果
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                    c--;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;

    }
}
