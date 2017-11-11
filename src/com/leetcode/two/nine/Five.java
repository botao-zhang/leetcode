package com.leetcode.two.nine;

import java.util.TreeMap;
import java.util.TreeSet;

public class Five {
    static class MedianFinder {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int hn = -1,hi = 0,ln = -1,li = 0;
        int cnt = 0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            cnt++;
            int existingCnt = map.getOrDefault(num,0) + 1;
            map.put(num,existingCnt);
            if(cnt % 2 == 0){
                if(num > hn){
                    if(hi == map.get(hn) - 1){
                        hn = map.higherKey(hn);
                        hi = 0;
                    }else{
                        hi++;
                    }
                }else if(num == hn){
                    hi++;
                }else{
                    if(li == 0){
                        ln = map.lowerKey(ln);
                        li = map.get(ln) - 1;
                    }else{
                        li--;
                    }
                }
            }else{
                if(cnt == 1){
                    hn = num;
                    ln = num;
                }else{
                    if(num >= hn){
                        ln = hn;
                        li = hi;
                    }else{
                        if(num == ln){
                            li++;
                        }else if(num > ln){
                            if(li < map.get(ln) - 1) li++;
                            else{
                                ln = map.higherKey(ln);
                                li = 0;
                            }
                        }
                        hn = ln;
                        hi = li;
                    }
                }
            }

        }

        public double findMedian() {
            return ((double) hn + (double) ln) / 2d;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
