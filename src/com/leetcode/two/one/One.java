package com.leetcode.two.one;

public class One {
    class WordDictionary {
        private class TrieNode{
            TrieNode[] nexts = new TrieNode[26];
            String word;
        }
        TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.nexts[c - 'a'] == null) cur.nexts[c - 'a'] = new TrieNode();
                cur = cur.nexts[c - 'a'];
            }
            cur.word = word;
        }

        private boolean search(TrieNode root,String word, int offset){
            if(offset == word.length()) return root.word != null;

            char c = word.charAt(offset);
            if(c != '.'){
                TrieNode next = root.nexts[c - 'a'];
                if(next == null) return false;
                return search(next,word,offset + 1);
            }else{
                for(int i = 0;i<26;i++){
                    if(root.nexts[i] != null){
                        if(search(root.nexts[i],word, offset + 1)) return true;
                    }
                }
                return false;
            }
        }
        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root,word,0);
        }
    }
}
