package com.leetcode.three.eight;

import java.util.ArrayList;
import java.util.List;

public class Six {
    private void helper(int cur,int n, List<Integer> ret){
        ret.add(cur);

        cur = cur * 10;
        for(int i = 0;i<10;i++){
            if(cur + i > n) break;
            helper(cur + i,n,ret);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            if(i > n) break;
            helper(i,n,ret);
        }
        return ret;
    }
}
