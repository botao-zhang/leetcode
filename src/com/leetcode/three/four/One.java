package com.leetcode.three.four;

import com.leetcode.util.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class One {
    public class NestedIterator implements Iterator<Integer> {
        private int i = 0;
        List<Integer> list = new ArrayList<>();
        private void flatten(NestedInteger ni){
            if(ni.isInteger()) list.add(ni.getInteger());
            else{
                for(NestedInteger nni : ni.getList()){
                    flatten(nni);
                }
            }
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            for(NestedInteger n : nestedList) flatten(n);
        }

        @Override
        public Integer next() {
            return list.get(i++);
        }

        @Override
        public boolean hasNext() {
            return i<list.size();
        }
    }

}
