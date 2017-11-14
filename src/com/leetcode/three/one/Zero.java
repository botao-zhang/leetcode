package com.leetcode.three.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Zero {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashSet<Integer>[] map = new HashSet[n];
        for(int i = 0;i<n;i++) map[i] = new HashSet<>();

        for(int[] edge :edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        int removed = 0;
        boolean[] deleted = new boolean[n];
        while (removed < n){
            List<Integer> toRemove = new ArrayList<>();

            for(int i = 0;i<n;i++){
                if(!deleted[i] && map[i].size() <= 1){
                    deleted[i] = true;
                    toRemove.add(i);
                }
            }
            removed += toRemove.size();
            if(removed == n) return toRemove;

            for(int removedN : toRemove){
                for(int num : map[removedN]){
                    map[num].remove(removedN);
                }
            }
        }
        return new ArrayList<>();
    }

}
