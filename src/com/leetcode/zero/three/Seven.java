package com.leetcode.zero.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Seven {
    private boolean helper(char[][] board,List<int[]> filling,int off,HashSet<Integer>[] rows,HashSet<Integer>[] cols,HashSet<Integer>[] squares){
        if(off == filling.size()) return true;

        int x = filling.get(off)[0],y = filling.get(off)[1];
        for(int i = 1;i<=9;i++){
            if(rows[x].contains(i)) continue;
            if(cols[y].contains(i)) continue;
            if(squares[x / 3 * 3 + y / 3].contains(i)) continue;
            rows[x].add(i);
            cols[y].add(i);
            squares[x / 3 * 3 + y / 3].add(i);
            board[x][y] = (char)('0' + i);
            if(helper(board,filling,off + 1,rows,cols,squares)) return true;
            rows[x].remove(i);
            cols[y].remove(i);
            squares[x / 3 * 3 + y / 3].remove(i);
            board[x][y] = '.';
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        for(int i = 0;i<9;i++) rows[i] = new HashSet<>();
        HashSet<Integer>[] cols = new HashSet[9];
        for(int i = 0;i<9;i++) cols[i] = new HashSet<>();
        HashSet<Integer>[] squares = new HashSet[9];
        for(int i = 0;i<9;i++) squares[i] = new HashSet<>();

        List<int[]> filling = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == '.'){
                    filling.add(new int[]{i,j});
                    continue;
                }
                int n = board[i][j] - '0';
                rows[i].add(n);
                cols[j].add(n);
                squares[i / 3 * 3 + j / 3].add(n);
            }
        }

        helper(board,filling,0,rows,cols,squares);
    }
}
