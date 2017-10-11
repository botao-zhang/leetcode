package com.leetcode.zero.seven;

public class Nine {
    private boolean find(char[][] board, boolean[][] used,String word, int off, int i, int j){
        if(off == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(used[i][j]) return false;
        if(board[i][j] != word.charAt(off)) return false;

        used[i][j] = true;
        if(find(board,used,word,off + 1,i - 1,j)) return true;
        if(find(board,used,word,off + 1,i + 1,j)) return true;
        if(find(board,used,word,off + 1,i,j - 1)) return true;
        if(find(board,used,word,off + 1,i,j + 1)) return true;

        used[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(find(board,used,word,0,i,j)) return true;
            }
        }
        return false;
    }
}
