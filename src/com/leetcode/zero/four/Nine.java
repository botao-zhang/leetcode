package com.leetcode.zero.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Nine {
    private String toKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String key = toKey(str);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                map.put(key,list);
            }
            list.add(str);
        }

        return new ArrayList<>(map.values());
    }
}
