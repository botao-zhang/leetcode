package com.leetcode.zero.three;

import java.util.HashSet;

public class Six {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        for(int i = 0;i<9;i++) rows[i] = new HashSet<>();
        HashSet<Integer>[] cols = new HashSet[9];
        for(int i = 0;i<9;i++) cols[i] = new HashSet<>();
        HashSet<Integer>[] squares = new HashSet[9];
        for(int i = 0;i<9;i++) squares[i] = new HashSet<>();

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == '.') continue;
                int n = board[i][j] - '0';
                if(!rows[i].add(n)) return false;
                if(!cols[j].add(n)) return false;
                if(!squares[i / 3 * 3 + j / 3].add(n)) return false;
            }
        }
        return true;
    }
}
