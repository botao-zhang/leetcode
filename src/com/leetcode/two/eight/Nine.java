package com.leetcode.two.eight;

public class Nine {
    int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    int cnt(int[][] board,int i,int j){
        int cnt = 0;
        for(int[] dir : dirs){
            int x = i + dir[0],y = j + dir[1];
            if(x >= 0&&x < board.length && y >= 0 && y< board[0].length){
                cnt += board[x][y] & 1;
            }
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                int cnt = cnt(board,i,j);
                if(board[i][j] == 1){
                    if(cnt == 2 || cnt == 3) board[i][j] = 3;
                }else{
                    if(cnt == 3) board[i][j] = 2;
                }
            }
        }

        for(int i = 0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >= 2 ? 1 : 0;
            }
        }
    }
}
