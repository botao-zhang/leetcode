package com.leetcode.three.eight;

import com.leetcode.util.NestedInteger;

public class Five {
    private int deser(String s,int start,NestedInteger parent){
        System.out.println("start = " + start + " parent = " + parent);
        if(start == s.length()) return start;
        NestedInteger ni = new NestedInteger();
        parent.add(ni);
        if(s.charAt(start) == '['){
            start++;
            while (start < s.length() && s.charAt(start) != ']'){
                start = deser(s,start,ni);
                if(s.charAt(start) == ',') start++;
            }
            if(start < s.length()) start++; //skip ']'
        }else{

            int i = start;
            while (start < s.length() && s.charAt(start) != ',' && s.charAt(start) != ']'){
                start++;
            }
            ni.setInteger(Integer.parseInt(s.substring(i,start)));

        }
        return start;
    }

    public NestedInteger deserialize(String s){
        NestedInteger parent = new NestedInteger();
        deser(s,0,parent);
        return parent.getList().size() > 0 ? parent.getList().get(0) : null;
    }

    public static void main(String[] args) {
        Five five = new Five();
//        System.out.println(five.deserialize(""));
//        System.out.println(five.deserialize("[]"));
//        System.out.println(five.deserialize("[1]"));
//        System.out.println(five.deserialize("1"));
        System.out.println(five.deserialize("[123,456,[788,799,833],[[]],10,[]]"));
        System.out.println(five.deserialize("[123,[788],[]]"));
    }
}
