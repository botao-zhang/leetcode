package com.leetcode.three.seven;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Eight {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });

        int cnt = 0,last = 0;
        pq.add(new int[]{0,0});
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        while (cnt < k){
            int[] ele = pq.remove();
            last = matrix[ele[0]][ele[1]];

            if(ele[0] < matrix.length - 1 && !used[ele[0] + 1][ele[1]]){
                pq.add(new int[]{ele[0] + 1,ele[1]});
                used[ele[0] + 1][ele[1]] = true;
            }
            if(ele[1] < matrix[0].length - 1 && !used[ele[0]][ele[1] + 1]){
                pq.add(new int[]{ele[0],ele[1] + 1});
                used[ele[0]][ele[1] + 1] = true;
            }

            cnt++;
        }

        return last;
    }
}
