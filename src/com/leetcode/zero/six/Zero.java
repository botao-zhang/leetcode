package com.leetcode.zero.six;

public class Zero {
    private int pick(boolean[] picked,int seq){

        int cnt = 0;
        for(int i = 0;i<picked.length;i++){
            if(!picked[i]){
                if(cnt == seq){
                    picked[i] = true;
                    return i + 1;
                }else{
                    cnt++;
                }
            }
        }
        return -1;
    }
    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for(int i = 1;i<=n;i++) fact[i] = fact[i - 1] * i;

        boolean[] picked = new boolean[n];
        StringBuilder ret = new StringBuilder();
        for(int i = n;i>=1;i--){
            int nums = fact[i - 1],seq = (k - 1) / nums;
            System.out.println("picking seq = " + seq + " i = " + i);
            ret.append(pick(picked,seq));
            k -= seq * nums;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Zero zero = new Zero();
        System.out.println(zero.getPermutation(3,2));
    }
}
