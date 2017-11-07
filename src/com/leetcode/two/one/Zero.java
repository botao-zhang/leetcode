package com.leetcode.two.one;

import java.util.LinkedList;
import java.util.Queue;

public class Zero {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] dependsOn = new boolean[numCourses][numCourses];
        int[] dependsOnCnt = new int[numCourses];

        for(int[] pre : prerequisites){
            dependsOn[pre[0]][pre[1]] = true;
            dependsOnCnt[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        int finished = 0;
        int[] todo = new int[numCourses];
        for(int i = 0;i<numCourses;i++) if(dependsOnCnt[i] == 0) q.offer(i);

        while (!q.isEmpty()){
            int course = q.poll();
            todo[finished++] = course;

            for(int i = 0;i<numCourses;i++){
                if(dependsOn[i][course]){
                    dependsOn[i][course] = false;
                    dependsOnCnt[i]--;
                    if(dependsOnCnt[i] == 0) q.offer(i);
                }
            }
        }
        if(finished < numCourses) return new int[0];
        return todo;
    }
}
