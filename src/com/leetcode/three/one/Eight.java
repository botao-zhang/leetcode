package com.leetcode.three.one;

public class Eight {
    public int maxProduct(String[] words) {
        boolean[][] map = new boolean[words.length][26];
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            for(char c : word.toCharArray()){
                map[i][c - 'a'] = true;
            }
        }

        int max = 0;
        for(int i = 0;i<words.length;i++){
            for(int j = i + 1;j<words.length;j++){
                boolean can = true;
                for(int k = 0;k<26;k++){
                    if(map[i][k] && map[j][k]){
                        can = false;
                        break;
                    }
                }
                if(can) max = Math.max(words[i].length() * words[j].length(),max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.maxProduct(new String[]{""}));
    }
}
