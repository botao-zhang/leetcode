package com.leetcode.three.three;

import java.util.*;

public class Six {
    private boolean isPali(String word){
        int off = 0,to = word.length() - 1;
        while (off < to){
            if(word.charAt(off++) != word.charAt(to--)) return false;
        }
        return true;
    }

    private void add(Integer i,Integer j,HashSet<List<Integer>> ret){
        if(i != null && j != null && !i.equals(j)){
            ret.add(Arrays.asList(i,j));
        }
    }

    public List<List<Integer>> palindromePairs(String[] words){
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<words.length;i++) map.put(words[i],i);
        HashSet<List<Integer>> ret = new HashSet<>();

        for(int j = 0;j<words.length;j++){
            String word = words[j];

            for(int i = 0;i<=word.length();i++){
                String pre = word.substring(0,i),suf = word.substring(i,word.length());

                if(isPali(pre)){
                    Integer other = map.get(new StringBuilder(suf).reverse().toString());
                    add(other,j,ret);
                }
                if(isPali(suf)){
                    Integer other = map.get(new StringBuilder(pre).reverse().toString());
                    add(j,other,ret);
                }
            }
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.palindromePairs(new String[]{"bat", "tab", "cat"}));
        System.out.println(six.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(six.palindromePairs(new String[]{"a", ""}));
        System.out.println(six.palindromePairs(new String[]{"a","abc","aba",""}));
    }
}
