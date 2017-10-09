package com.leetcode.zero.six;

public class Five {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean first = true,hasE = false,hasPreceeding = false,hasDot = false,hasAfterDot = false,hasAfterE = false;
        for(char c : s.toCharArray()){
            if((c == '+' || c == '-')){
                if(!first && !(hasE && !hasAfterE)) return false;
            }else if(Character.isDigit(c)){
                hasPreceeding = true;
                if(hasDot) hasAfterDot = true;
                if(hasE) hasAfterE = true;
            }else if(c == '.'){
                if(hasDot || hasE) return false;
                hasDot = true;
            }else if(c == 'e'){
                if(!hasPreceeding || hasE) return false;
                hasE = true;
            }else{
                return false;
            }
            first = false;
        }
        if(hasE && !hasAfterE) return false;
        return hasPreceeding;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.isNumber("-1."));
    }
}
