package com.leetcode.one.three;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Nine {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] can = new boolean[s.length() + 1];
        can[s.length()] = true;

        for(int i = s.length() - 1;i>= 0;i--){
            for(String word : wordDict){
                if(s.startsWith(word,i) && can[i + word.length()]){
                    can[i] = true;
                    break;
                }
            }
        }
        return can[0];
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        System.out.println(nine.wordBreak("leetcode", Arrays.asList("leet","code")));
    }
}
