package com.leetcode.three.zero;

import java.util.*;

public class One {
    private HashSet<String> remove(StringBuilder cur, int from, int to, char c){
        HashSet<String> ret = new HashSet<>();
        System.out.println("looping " + " cur = " + cur + " from = " + from + " to = " + to);

        for(int i = from;i<=to;i++){

            if(cur.charAt(i) == c && (i == from || cur.charAt(i - 1) != c)){
                cur.deleteCharAt(i);

                ret.add(cur.toString());
                System.out.println("deleting cur = " + cur + " ret size = " + ret.size());

                cur.insert(i,c);
            }
        }
        System.out.println("ret = " + ret + " cur = " + cur + " from = " + from + " to = " + to);

        return ret;

    }

    public List<String> removeInvalidParentheses(String s) {
        int b = 0;

        HashSet<String> ret = new HashSet<>();
        if(s == null) return new ArrayList<>(ret);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') b++;
            else if (s.charAt(i) == ')') {
                b--;
                if (b < 0) {
                    HashSet<String> removed = remove(new StringBuilder(s), 0, i, ')');
                    for(String str : removed){
                        ret.addAll(removeInvalidParentheses(str));
                    }
                    return new ArrayList<>(ret);
                }
            }
        }

        b = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') b++;
            else if (s.charAt(i) == '(') {
                b--;
                if (b < 0) {
                    HashSet<String> removed = remove(new StringBuilder(s), i, s.length() - 1, '(');
                    for(String str : removed){
                        ret.addAll(removeInvalidParentheses(str));
                    }
                    return new ArrayList<>(ret);
                }
            }
        }

        ret.add(s);
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        One one = new One();
//        System.out.println(one.removeInvalidParentheses("()())()"));
//        System.out.println(one.removeInvalidParentheses("(a)())()"));
        //System.out.println(one.removeInvalidParentheses(")("));
        System.out.println(one.removeInvalidParentheses("(("));
    }
}
