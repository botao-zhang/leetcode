package com.leetcode.one.three;

import java.util.ArrayList;
import java.util.List;

public class One {
    private void help(String s,boolean[][] isPali,int off,List<String> cur,List<List<String>> ret){
        if(off == s.length()){
            ret.add(new ArrayList<>(cur));
            return;
        }

        for(int i = off;i<s.length();i++){
            if(isPali[off][i]){
                cur.add(s.substring(off,i+1));
                help(s,isPali,i + 1,cur,ret);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        boolean[][] isPali = new boolean[s.length()][s.length()];

        for(int i = s.length() - 1;i>=0;i--){
            isPali[i][i] = true;
            for(int j = i + 1;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    isPali[i][j] = j == i + 1 || isPali[i + 1][j - 1];
                }
            }
        }
        List<List<String>> ret = new ArrayList<>();
        help(s,isPali,0,new ArrayList<>(),ret);
        return ret;
    }
}
