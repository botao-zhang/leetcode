package com.leetcode.two.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Two {
    private class TrieNode{
        TrieNode[] nexts = new TrieNode[26];
        String word;
    }
    TrieNode root = new TrieNode();

    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.nexts[c - 'a'] == null) cur.nexts[c - 'a'] = new TrieNode();
            cur = cur.nexts[c - 'a'];
        }
        cur.word = word;
    }

    private void search(TrieNode root, char[][] board, int i, int j,HashSet<String> ret){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] > 0){
            char c = board[i][j];
            TrieNode next = root.nexts[c - 'a'];
            if(next != null){
                if(next.word != null) ret.add(next.word);
                board[i][j] = 0;
                for(int[] dir : dirs){
                    search(next,board,i + dir[0],j + dir[1],ret);
                }
                board[i][j] = c;
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words) addWord(word);
        HashSet<String> ret = new HashSet<>();

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                search(root,board,i,j,ret);
            }
        }
        return new ArrayList<>(ret);
    }
}
