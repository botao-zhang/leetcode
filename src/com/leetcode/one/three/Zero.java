package com.leetcode.one.three;

public class Zero {
    private static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    private void dfs(char[][] board,int i,int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(board[i][j] == 'O'){
            board[i][j] = 'A';
            for(int[] dir : dirs) dfs(board,i + dir[0],j + dir[1]);
        }
    }

    public void solve(char[][] board) {
        if(board.length == 0) return;
        for(int i = 0;i<board.length;i++) dfs(board,i,0);
        for(int i = 0;i<board.length;i++) dfs(board,i,board[0].length - 1);
        for(int i = 0;i<board[0].length;i++) dfs(board,0,i);
        for(int i = 0;i<board[0].length;i++) dfs(board,board.length - 1,i);

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'A') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
}
