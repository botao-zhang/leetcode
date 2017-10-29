package com.leetcode.one.two;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Seven {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);

        Queue<String> q = new LinkedList<>();
        int level = 1;
        q.offer(beginWord);

        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++){
                String word = q.poll();
                if(word.equals(endWord)) return level;

                StringBuilder builder = new StringBuilder(word);
                for(int k = 0;k<word.length();k++){
                    for(char c = 'a';c <= 'z';c++){
                        if(c == word.charAt(k)) continue;
                        builder.setCharAt(k,c);
                        if(set.remove(builder.toString())){
                            q.offer(builder.toString());
                        }
                    }
                    builder.setCharAt(k,word.charAt(k));
                }
            }
            level++;
        }
        return 0;
    }
}
