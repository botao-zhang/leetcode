package com.leetcode.zero.eight;

import java.util.ArrayList;
import java.util.List;

public class Nine {
    int gen(int num,int offset,List<Integer> ret){
        if(offset < 0){
            ret.add(num);
            return num;
        }

        int next = gen(num,offset - 1,ret);
        next ^= (1 << offset);

        return gen(next,offset - 1,ret);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        gen(0,n - 1,ret);
        return ret;
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        System.out.println(nine.grayCode(0));
        System.out.println(nine.grayCode(1));
        System.out.println(nine.grayCode(2));
        System.out.println(nine.grayCode(3));
    }
}
