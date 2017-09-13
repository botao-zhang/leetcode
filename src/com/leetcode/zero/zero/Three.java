package com.leetcode.zero.zero;

/**
 * Created by botao on 2017/9/13.
 */
public class Three {
    public int lengthOfLongestSubstring(String s) {
        boolean[] occured = new boolean[256];
        int slow = 0,fast = 0,max = 0;
        for(;fast < s.length();fast++){
            if(occured[s.charAt(fast)]) {
                max = Math.max(fast - slow, max);
                while (s.charAt(slow) != s.charAt(fast)) {
                    occured[s.charAt(slow)] = false;
                    slow++;
                }
                slow++;
            }
            occured[s.charAt(fast)] = true;
        }
        max = Math.max(max,s.length() - slow);
        return max;
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(three.lengthOfLongestSubstring("aaaa"));
        System.out.println(three.lengthOfLongestSubstring("pwwkew"));

    }
}
