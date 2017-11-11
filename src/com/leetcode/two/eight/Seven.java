package com.leetcode.two.eight;

public class Seven {
    public int findDuplicate(int[] nums) {
        int from = 1,to = nums.length - 1;

        while (from <= to){
            int mid = (from + to) / 2;
            int gap = mid - from + 1;
            int cnt = 0,mcnt = 0;
            for(int n : nums){
                if(n == mid) mcnt++;
                if(n <= mid && n >= from) cnt++;
            }
            if(mcnt > 1) return mid;

            if(cnt > gap){
                to = mid;
            }else{
                from = mid + 1;
            }
        }
        return 0;
    }


}
