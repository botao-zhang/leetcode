package com.leetcode.zero.two;

import java.util.ArrayList;
import java.util.List;

public class Two {
    private void helper(StringBuilder cur,int pair, int open, int n,List<String> ret){
        if(pair == n) ret.add(cur.toString());
        else{
            if(pair + open < n) {
                cur.append('(');
                helper(cur, pair, open+1, n,ret);
                cur.deleteCharAt(cur.length() - 1);
            }

            if(open > 0){
                cur.append(')');
                helper(cur,pair + 1,open - 1,n,ret);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if(n == 0) return ret;
        helper(new StringBuilder(),0,0,n,ret);
        return ret;
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.generateParenthesis(3));
    }
}
