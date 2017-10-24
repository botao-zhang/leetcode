package com.leetcode.zero.nine;

public class One {
    private boolean canBeTens(String s, int start){
        if(start == s.length() - 1) return false;
        if(s.charAt(start) == '1') return true;
        if(s.charAt(start) == '2' && s.charAt(start + 1) < '7') return true;
        return false;
    }

    public int numDecodings(String s) {
        if(s.isEmpty()) return 0;

        int[] ways = new int[s.length() + 1];
        ways[s.length()] = 1;
        for(int i = s.length() - 1;i>=0;i--){
            if(s.charAt(i) != '0'){
                ways[i] = ways[i + 1];
                if(canBeTens(s,i)) ways[i] += ways[i + 2];
            }
        }
        return ways[0];
    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.numDecodings("0"));
    }
}
