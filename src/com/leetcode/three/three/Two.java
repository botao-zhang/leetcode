package com.leetcode.three.three;

import java.util.*;

public class Two {
    private List<String> help(String[][] tickets,HashMap<String,List<Integer>> map,List<String> cur, boolean[] used){
        if(cur.size() == tickets.length + 1) return cur;

        String now = cur.get(cur.size() - 1);
        List<Integer> nexts = map.get(now);
        if(nexts == null) return null;
        for(int next : nexts){
            if(!used[next]){
                used[next] = true;
                cur.add(tickets[next][1]);

                List<String> ret = help(tickets,map,cur,used);
                if(ret != null) return ret;
                used[next] = false;
                cur.remove(cur.size() -1);
            }
        }
        return null;
    }

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String,List<Integer>> map = new HashMap<>();

        int cnt = tickets.length;
        for(int i = 0;i<tickets.length;i++){
            String[] ticket = tickets[i];
            List<Integer> dests = map.get(ticket[0]);
            if(dests == null){
                dests = new ArrayList<>();
                map.put(ticket[0],dests);
            }
            dests.add(i);
        }

        for(String start : map.keySet()){
            map.get(start).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return tickets[o1][1].compareTo(tickets[o2][1]);
                }
            });
        }

        List<String> ret = new ArrayList<>();
        ret.add("JFK");


        return help(tickets,map,ret,new boolean[tickets.length]);
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.findItinerary(new String[][]{{"MUC", "LHR"},{"JFK", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}}));
        System.out.println(two.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}));
        System.out.println(two.findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}));
    }
}
