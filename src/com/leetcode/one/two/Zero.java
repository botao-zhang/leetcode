package com.leetcode.one.two;

import java.util.ArrayList;
import java.util.List;

public class Zero {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()) return 0;
        List<Integer> last = null;
        for(int i = triangle.size() - 1;i>=0;i--){
            List<Integer> row = triangle.get(i);
            List<Integer> costs = new ArrayList<>();

            for(int j = 0;j<row.size();j++){
                if(last == null) costs.add(row.get(j));
                else costs.add(row.get(j) + Math.min(last.get(j),last.get(j + 1)));
            }
            last = costs;
        }

        return last.get(0);
    }
}
