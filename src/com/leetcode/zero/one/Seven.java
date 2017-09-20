package com.leetcode.zero.one;

import java.util.ArrayList;
import java.util.List;

public class Seven {

    private char[] starts = new char[]{' ',' ','a','d','g','j','m','p','t','w',(char) ('z' + 1)};
    private void helper(String digs, int offset, StringBuilder cur, List<String> ret){
        if(offset == digs.length()){
            ret.add(cur.toString());
            return;
        }

        for(char c = starts[digs.charAt(offset) - '0'];c < starts[digs.charAt(offset) - '0' + 1];c++){
            cur.append(c);
            helper(digs,offset+1,cur,ret);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ret = new ArrayList<>();
        if(digits.length() == 0) return ret;
        helper(digits,0,new StringBuilder(),ret);
        return ret;
    }

    public static void main(String[] args) {
        Seven seven = new Seven();
        System.out.println(seven.letterCombinations("7"));
    }
}
