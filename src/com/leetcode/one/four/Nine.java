package com.leetcode.one.four;

import com.leetcode.util.Point;

import java.util.HashMap;

public class Nine {
    private int gcd(int big,int small){
        if(big < small) return gcd(small,big);
        if(small < 0) return -1 * gcd(big,small * - 1);
        if(small == 0) return 1;

        int reminder = big % small;
        if(reminder == 0) return small;

        return gcd(small,reminder);
    }

    public int maxPoints(Point[] points) {
        if(points.length < 3) return points.length;
        int max = 0;
        for(int i = 0;i<points.length;i++){
            int samePtrs = 1,verti = 0,hori = 0;
            HashMap<Integer,HashMap<Integer,Integer>> cnts = new HashMap<>();

            for(int j = 0;j<points.length;j++){
                if(j == i) continue;
                if(points[i].x == points[j].x){
                    if(points[j].y == points[i].y){
                        samePtrs++;
                    }else{
                        verti++;
                    }
                    max = Math.max(samePtrs + verti,max);
                }else{
                    int dx = points[j].x - points[i].x,dy = points[j].y - points[i].y;

                    if(dy == 0){
                        hori++;
                        max = Math.max(hori + samePtrs, max);
                    }else {
                        int gcd = gcd(dy, dx);
                        dy /= gcd;
                        dx /= gcd;
                        HashMap<Integer, Integer> ymap = cnts.get(dx);
                        if (ymap == null) {
                            ymap = new HashMap<>();
                            cnts.put(dx, ymap);
                        }

                        int cnt = ymap.getOrDefault(dy, 0) + 1;
                        max = Math.max(cnt + samePtrs, max);
                        ymap.put(dy, cnt);
                    }
                }


            }
            System.out.println("i = " + i + " cnts = " + cnts);
        }
        return max;
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        System.out.println(nine.gcd(4,1));
        System.out.println(nine.gcd(4,6));
        System.out.println(nine.gcd(-4,6));
        System.out.println(nine.gcd(-4,-6));

        System.out.println(nine.maxPoints(new Point[]{new Point(0,0),new Point(1,0)}));
        System.out.println(nine.maxPoints(new Point[]{new Point(2,3),new Point(3,3),new Point(-5,3)}));
    }
}
