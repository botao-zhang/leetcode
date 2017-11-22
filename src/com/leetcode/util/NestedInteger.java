package com.leetcode.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedInteger {
    List<NestedInteger> list = new ArrayList<>();
    Integer v = null;
    public NestedInteger(){

    }
    public NestedInteger(int num){

    }
    public boolean isInteger(){
        return v != null;
    }
    public Integer getInteger(){
        return v;
    }
    public List<NestedInteger> getList(){
        return list;
    }
    public void setInteger(int value){
        v = value;
    }
    public void add(NestedInteger ni){
        list.add(ni);
    }

    @Override
    public String toString() {
        if(isInteger()){
            return v.toString();
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for(NestedInteger ni : getList()){
            builder.append(ni);
            builder.append(',');
        }
        builder.append(']');
        return builder.toString();
    }
}
