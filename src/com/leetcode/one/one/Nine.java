package com.leetcode.one.one;

import java.util.ArrayList;
import java.util.List;

public class Nine {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = null;
        rowIndex++;
        for(int i = 1;i<=rowIndex;i++){
            List<Integer> level = new ArrayList<>();
            for(int j = 0;j<i;j++){
                if(j == 0||j == i - 1)level.add(1);
                else level.add(last.get(j) + last.get(j - 1));
            }
            last = level;
        }
        return last;
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        System.out.println(nine.getRow(0));
    }
}
