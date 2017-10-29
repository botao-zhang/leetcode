package com.leetcode.one.two;

public class Five {
    public boolean isPalindrome(String s) {
        int b = 0,e = s.length() - 1;
        while (b < e){
            char bc = s.charAt(b),ec = s.charAt(e);
            if(!Character.isAlphabetic(bc) && !Character.isDigit(bc)){
                b++;
                continue;
            }
            if(!Character.isAlphabetic(ec) && !Character.isDigit(ec)){
                e--;
                continue;
            }

            if(Character.isAlphabetic(bc)) bc = Character.toLowerCase(bc);
            if(Character.isAlphabetic(ec)) ec = Character.toLowerCase(ec);
            if(bc != ec) return false;
            b++;
            e--;
        }
        return true;
    }
}
