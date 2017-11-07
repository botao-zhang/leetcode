package com.leetcode.two.one;

public class Four {
    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int end = s.length() - 1,i = 0,j = end;
        while (i < j){
            if(chars[i] == chars[j]){
                i++;
                j--;
            }else{
                i = 0;
                end--;
                j = end;
            }

        }

        if(end == s.length() - 1) return s;
        StringBuilder builder = new StringBuilder(s.substring(end + 1));
        builder.reverse();
        builder.append(s);
        return  builder.toString();
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.shortestPalindrome("a"));
        System.out.println(four.shortestPalindrome(""));
        System.out.println(four.shortestPalindrome("aacecaaa"));
        System.out.println(four.shortestPalindrome("abcd"));
    }
}
