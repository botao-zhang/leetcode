package com.leetcode.zero.seven;

import java.util.ArrayList;
import java.util.List;

public class Seven {
    private void help(int n,int off, List<Integer> now,int k,List<List<Integer>> ret){
        if(now.size() == k){
            ret.add(new ArrayList<>(now));
            return;
        }
        if(off > n) return;
        now.add(off);
        help(n,off + 1,now,k,ret);
        now.remove(now.size() - 1);
        help(n,off + 1,now,k,ret);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        help(n,1,new ArrayList<>(),k,ret);
        return ret;
    }
}
