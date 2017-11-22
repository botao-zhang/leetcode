package com.leetcode.three.seven;

public class Four {
    private int guess(int num){
        return 0;
    }

    public int guessNumber(int n) {
        int from = 1,to = n;
        while (from <= to){
            int mid = from + (to - from)/ 2;
            int ret = guess(mid);
            if(ret == 0) return mid;
            if(ret < 0) to = mid - 1;
            else from = mid + 1;
        }
        return 0;
    }
}
