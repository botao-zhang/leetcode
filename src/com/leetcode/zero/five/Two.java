package com.leetcode.zero.five;

import java.util.ArrayList;
import java.util.List;

public class Two {
    int answer = 0;
    private boolean valid(List<String> existing, int j){
        for (int i = existing.size() - 1;i>=0;i--){
            String string = existing.get(i);
            if(string.charAt(j) != '.') return false;
            int diff = existing.size() - i;
            if(j - diff >= 0 && string.charAt(j - diff) != '.') return false;
            if(j + diff < string.length() && string.charAt(j + diff) != '.') return false;
        }
        return true;
    }

    private void place(int n,List<String> existing){
        if(n == existing.size()){
            answer++;
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<n;i++) stringBuilder.append('.');
        for(int i = 0;i<n;i++){
            if(valid(existing,i)){
                stringBuilder.setCharAt(i,'Q');
                existing.add(stringBuilder.toString());
                place(n,existing);
                existing.remove(existing.size() - 1);
                stringBuilder.setCharAt(i,'.');
            }
        }
    }

    public int totalNQueens(int n) {
        place(n,new ArrayList<>());
        return answer;
    }
}
