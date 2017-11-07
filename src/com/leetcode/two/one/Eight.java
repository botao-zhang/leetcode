package com.leetcode.two.one;

import java.util.*;

public class Eight {
    public List<int[]> getSkyline(int[][] buildings) {
        TreeMap<Integer,Integer> pMap = new TreeMap<>();

        for(int[] building : buildings){
            int start = -1,nh = 0,end = -1,ph = building[2];
            Map.Entry<Integer,Integer> beforeStart = pMap.floorEntry(building[0]);
            if(beforeStart == null || beforeStart.getValue() < building[2]){
                start = building[0];
            }else{
                ph = beforeStart.getValue();
            }


            Map.Entry<Integer,Integer> beforeEnd = pMap.floorEntry(building[1]);
            if(beforeEnd == null || beforeEnd.getValue() < building[2]){
                end = building[1];
                if(beforeEnd != null) nh = beforeEnd.getValue();
            }

            //System.out.println("new building = " + Arrays.toString(building) + " start = " + start + " end = " + end + " nh = " + nh + " ph = " + ph);
            Map.Entry<Integer,Integer> mid = pMap.ceilingEntry(building[0]);

            while (mid != null && mid.getKey() <= building[1]){
                if(mid.getValue() < building[2]){
                    if(ph == building[2]) pMap.remove(mid.getKey());
                    else pMap.put(mid.getKey(),building[2]);
                }
                mid = pMap.higherEntry(mid.getKey());
            }

            if(start >= 0) pMap.put(start,building[2]);
            if(end >= 0) pMap.put(end,nh);
            //System.out.println("After building " + Arrays.toString(building) + " map = " + pMap);
        }

        List<int[]> ret = new ArrayList<>();
        int prevH = 0;
        for(Map.Entry<Integer,Integer> entry : pMap.entrySet()){
            if(prevH != entry.getValue()) {
                ret.add(new int[]{entry.getKey(), entry.getValue()});
                prevH = entry.getValue();
            }
        }
        return ret;
    }

}
