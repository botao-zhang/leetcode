package com.leetcode.zero.zero;

public class Six {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] subs = new StringBuilder[numRows];
        for(int i = 0;i<numRows;i++) subs[i] = new StringBuilder();

        int curRow = 0,curChar = 0;
        boolean down = true;
        while (curChar < s.length()){
            subs[curRow].append(s.charAt(curChar++));
            if(down) curRow++;
            else curRow--;

            if(curRow == 0) down = true;
            else if(curRow == numRows - 1) down = false;
        }
        for(int i = 1;i<numRows;i++) subs[0].append(subs[i]);
        return subs[0].toString();
    }
}
