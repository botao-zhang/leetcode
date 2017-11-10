package com.leetcode.two.seven;

public class Eight {
    private static class VersionControl{
        int i = 1;
        boolean isBadVersion(int version){
            return false;
        }
    }
    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int from = 1, to = n;

            while (from <= to){
                int mid = from + (to - from) / 2;
                if(isBadVersion(mid)){
                    to = mid - 1;
                }else{
                    from = mid + 1;
                }
            }
            return from;
        }
    }
}
