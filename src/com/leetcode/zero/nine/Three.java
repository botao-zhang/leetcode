package com.leetcode.zero.nine;

import java.util.ArrayList;
import java.util.List;

public class Three {
    private void helper(String s,int off,int left,StringBuilder cur,List<String> ret){
        if(s.length() - off > 3 * left || s.length() - off < left) return;
        if(off == s.length()){
            if(left == 0) ret.add(cur.toString());
            return;
        }

        int dig = 0,curLen = cur.length();

        for(int i = 0;i<3;i++){
            if(off + i >= s.length()) break;
            dig = dig * 10 + s.charAt(off + i) - '0';
            if(dig > 255) break;
            if(left != 4) cur.append('.');
            cur.append(dig);
            helper(s,off+i+1,left-1,cur,ret);
            cur.delete(curLen,cur.length());
            if(dig == 0) break;
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        helper(s,0,4,new StringBuilder(),ret);
        return ret;
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.restoreIpAddresses("25525511135"));
    }
}
