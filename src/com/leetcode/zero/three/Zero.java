package com.leetcode.zero.three;

import java.util.*;

public class Zero {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0) return Collections.emptyList();
        int len = words[0].length();
        HashMap<String,Integer> set = new HashMap<>();
        for(String word : words) set.put(word,set.getOrDefault(word,0) + 1);

        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i<len;i++){
            int start = i,end = i;
            HashMap<String,Integer> curSet = new HashMap<>(set);
            while (end + len <= s.length()){
                //System.out.println("start = " + start + " end = " + end + " cur = " + curSet);

                String sub = s.substring(end,end + len);
                Integer cnt = curSet.get(sub);
                if(cnt == null){
                    while (start < end){
                        String startStr = s.substring(start,start+len);
                        if(startStr.equals(sub)) break;
                        curSet.put(startStr,curSet.getOrDefault(startStr,0) + 1);
                        start += len;
                    }
                    start += len;
                }else {
                    cnt--;
                    if(cnt == 0) {
                        curSet.remove(sub);
                        if(curSet.isEmpty()){
                            ret.add(start);
                            String startStr = s.substring(start,start+len);
                            curSet.put(startStr,curSet.getOrDefault(startStr,0) + 1);
                            start += len;
                        }
                    }else {
                        curSet.put(sub,cnt);
                    }
                }

                end += len;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Zero zero = new Zero();
        System.out.println(zero.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
    }
}
