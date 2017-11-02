package com.leetcode.one.six;

public class Five {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for(;i<Math.min(v1.length,v2.length);i++){
            Integer part1 = Integer.parseInt(v1[i]), part2 = Integer.parseInt(v2[i]);
            if(part1 != part2) return part1 < part2 ? -1 : 1;
        }

        for(;i<v1.length;i++) if(Integer.parseInt(v1[i]) != 0) return 1;
        for(;i<v2.length;i++) if(Integer.parseInt(v2[i]) != 0) return -1;

        return 0;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.compareVersion("0.1","1"));
        System.out.println(five.compareVersion("1.1","1.1.3"));
    }
}
