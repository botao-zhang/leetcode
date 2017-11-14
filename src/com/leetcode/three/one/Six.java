package com.leetcode.three.one;

import java.util.*;

public class Six {
    private String helper(Deque<Integer>[] occs,int chars){
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i<chars;i++){
            for(int m = 0;m<26;m++){
                if(occs[m].isEmpty()) continue;
                boolean canAdd = true;
                for(int n = m+1;n<26;n++){
                    if(occs[n].isEmpty()) continue;
                    if(occs[n].getLast() < occs[m].getFirst()){
                        canAdd = false;
                        break;
                    }
                }
                if(canAdd){
                    for(int k = 0;k<26;k++){
                        while (!occs[k].isEmpty() && occs[k].getFirst() < occs[m].getFirst()){
                            occs[k].removeFirst();
                        }
                    }
                    ret.append((char) ('a' + m));
                    occs[m].clear();
                    break;
                }
            }
        }
        return ret.toString();
    }

    public String removeDuplicateLetters(String s) {
        Deque<Integer>[] occs = new Deque[26];
        for(int i = 0;i<26;i++) occs[i] = new LinkedList<>();
        int chars = 0;
        for(int i = 0;i<s.length();i++){
            if(occs[s.charAt(i) - 'a'].isEmpty()) chars++;
            occs[s.charAt(i) - 'a'].addLast(i);
        }

        StringBuilder ret = new StringBuilder();
        return helper(occs,chars);
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.removeDuplicateLetters("bcabc"));
        System.out.println(six.removeDuplicateLetters("cbacdcbc"));
    }
}
