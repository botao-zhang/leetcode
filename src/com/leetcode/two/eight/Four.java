package com.leetcode.two.eight;

import java.util.Iterator;

public class Four {
    class PeekingIterator implements Iterator<Integer> {
        Integer cache = null;
        Iterator<Integer> iter;
        public PeekingIterator(Iterator<Integer> iterator) {
            this.iter = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if(cache != null) return cache;
            cache = iter.next();
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(cache != null){
                Integer v = cache;
                cache = null;
                return v;
            }

            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return cache != null || iter.hasNext();
        }
    }
}
