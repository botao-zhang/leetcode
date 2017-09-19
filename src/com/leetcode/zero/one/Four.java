package com.leetcode.zero.one;

public class Four {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int common = 0;

        while (common < strs[0].length()){
            for(int i = 1;i<strs.length;i++) {
                if (common >= strs[i].length() || strs[0].charAt(common) != strs[i].charAt(common))
                    return strs[0].substring(0, common);
            }
            common++;
        }
        return strs[0];
    }
}
