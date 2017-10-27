package com.leetcode.one.one;

import java.util.ArrayList;
import java.util.List;

public class Eight {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            List<Integer> level = new ArrayList<>();
            for(int j = 0;j<i;j++){
                if(j == 0||j == i - 1)level.add(1);
                else{
                    level.add(ret.get(ret.size() - 1).get(j) + ret.get(ret.size() - 1).get(j - 1));
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.generate(5));
    }
}
