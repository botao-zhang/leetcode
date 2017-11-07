package com.leetcode.two.one;

import java.util.ArrayList;
import java.util.List;

public class Six {
    private void help(int off, int k, int n, List<Integer> cur,List<List<Integer>> ret){
        if(n <= 0 || off == 10 || cur.size() > k){
            if(n == 0 && cur.size() == k) ret.add(new ArrayList<>(cur));
            return;
        }

        help(off + 1,k,n,cur,ret);
        cur.add(off);
        help(off + 1,k,n - off,cur,ret);
        cur.remove(cur.size() - 1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        help(1,k,n,new ArrayList<>(),ret);
        return ret;
    }
}
