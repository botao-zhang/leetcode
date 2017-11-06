package com.leetcode.two.zero;

import com.leetcode.util.TreeNode;

public class Eight {
    class Trie {
        private class TrieNode{
            TrieNode[] nexts = new TrieNode[26];
            String word;
        }
        TrieNode root = new TrieNode();
        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.nexts[c - 'a'] == null) cur.nexts[c - 'a'] = new TrieNode();
                cur = cur.nexts[c - 'a'];
            }
            cur.word = word;
        }

        private TrieNode locate(String prefix){
            TrieNode cur = root;
            for(char c : prefix.toCharArray()){
                cur = cur.nexts[c - 'a'];
                if(cur == null) break;
            }
            return cur;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = locate(word);
            return node != null && node.word != null;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = locate(prefix);
            return node != null;
        }
    }
}
