package com.leetcode.three.six;

public class Seven {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        if(num <= 1) return true;
        int from = 1,to = num - 1;
        while (from <= to){
            long mid = (from + to) / 2;
            long square = mid * mid;
            if(square == num) return true;
            if(square > num) to = (int) (mid - 1);
            else from = (int) (mid + 1);
        }

        return false;
    }
}
