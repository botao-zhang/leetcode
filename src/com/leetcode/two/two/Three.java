package com.leetcode.two.two;

public class Three {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);

        int maxL = Math.max(A,E);
        int minR = Math.min(C,G);
        int maxB = Math.max(B,F);
        int minT = Math.min(D,H);

        if(maxL >= minR || maxB >= minT) return total;

        return total - (minT - maxB) * (minR - maxL);
    }
}
