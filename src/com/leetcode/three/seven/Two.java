package com.leetcode.three.seven;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Two {
    public int superPow(int a, int[] b) {
        List<Integer> ret = new ArrayList<>();
        int[] idx = new int[1337];
        Arrays.fill(idx,-1);
        a = a % 1337;
        java.math.BigDecimal bigDecimal = new java.math.BigDecimal(0);
        for(int i = 0;i < b.length;i++){
            bigDecimal = bigDecimal.multiply(new java.math.BigDecimal(10));
            bigDecimal = bigDecimal.add(new java.math.BigDecimal(b[i]));
        }

        int cur = 1;
        while (!bigDecimal.equals(new java.math.BigDecimal(0))){
            cur *= a;
            cur = cur % 1337;
            if(idx[cur] >= 0){
                int llen = ret.size() - idx[cur];
                bigDecimal = bigDecimal.subtract(new java.math.BigDecimal(1));
                bigDecimal = bigDecimal.remainder(new java.math.BigDecimal(llen));

                int step = bigDecimal.intValue();
                return ret.get(idx[cur] + step);
            }else{
                ret.add(cur);
                idx[cur] = ret.size() - 1;
            }
            bigDecimal = bigDecimal.subtract(new java.math.BigDecimal(1));
        }
        return ret.get(ret.size() - 1);
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.superPow(2,new int[]{1}));
        System.out.println(two.superPow(2,new int[]{1,0}));
        System.out.println(two.superPow(2,new int[]{2,0}));
    }
}
