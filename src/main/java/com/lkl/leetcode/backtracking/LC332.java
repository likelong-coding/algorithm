package com.lkl.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author likelong
 * @date 2023/1/4
 */
public class LC332 {

    @Test
    public void test() {
        String str1 = "SFO";
        String str2 = "ATL";

        System.out.println(str1.compareTo(str2));

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

//        tickets.add(Arrays.asList("JFK", "KUL"));
//        tickets.add(Arrays.asList("JFK", "NRT"));
//        tickets.add(Arrays.asList("NRT", "JFK"));

        System.out.println(findItinerary(tickets));

    }

    /*
    输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    输出：["JFK","MUC","LHR","SFO","SJC"]

    输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    输出：["JFK","ATL","JFK","SFO","ATL","SFO"]

    输入：[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
     */

    List<List<String> > ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    /**
     * 标识数组元素是否用过，用过的元素不能再用了
     */
    boolean[] used = new boolean[300];

    /***
     * 找到一个行程即可，标记是否找到行程
     */
    boolean find = false;

    public List<String> findItinerary(List<List<String>> tickets) {

        // 根据目的地从小到大排序
        tickets.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));
        path.add("JFK");
        backtracking(tickets, "JFK");
        System.out.println(ans);
        return ans.get(0);
    }

    public void backtracking(List<List<String>> tickets, String outset) {
        // 相当于剪枝，剪去其余多种情况
        if(find){
            // 找到一条路线直接返回
            return;
        }

        if (path.size() == tickets.size() + 1) {
            find = true;
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            // 用过的元素直接跳过
            if (used[i]) {
                continue;
            }
            if (tickets.get(i).get(0).equals(outset)) {
                path.add(tickets.get(i).get(1));
                used[i] = true;
                // 递归
                backtracking(tickets, path.get(path.size() - 1));
                // 回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
