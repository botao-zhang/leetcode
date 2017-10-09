package com.leetcode.zero.six;

import java.util.ArrayList;
import java.util.List;

public class Eight {
    public List<String> fullJustify(String[] words, int maxWidth){
        int lineLen = 0, lineStart = 0;
        List<String> ret = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            if(words[i].length() + lineLen + i - lineStart > maxWidth){
                int wordsInLine = i - lineStart, padding = maxWidth - lineLen, basePadding = wordsInLine == 1 ? 0 : padding / (wordsInLine - 1), extra = wordsInLine == 1 ? 0 : padding % (wordsInLine - 1);

                StringBuilder stringBuilder = new StringBuilder();
                for(int j = lineStart;j<i;j++){
                    if(j != lineStart){
                        for(int k = 0;k<basePadding;k++) stringBuilder.append(' ');
                        if(j - lineStart - 1 < extra) stringBuilder.append(' ');
                    }
                    stringBuilder.append(words[j]);
                    if(wordsInLine == 1)for(int k = 0;k<padding;k++) stringBuilder.append(' ');
                }
                ret.add(stringBuilder.toString());
                lineLen = 0;
                lineStart = i;
            }
            lineLen += words[i].length();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = lineStart;j<words.length;j++){
            if(j != lineStart)stringBuilder.append(' ');
            stringBuilder.append(words[j]);
        }

        int left = maxWidth - stringBuilder.length();
        for(int i = 0;i<left;i++){
            stringBuilder.append(' ');
        }
        ret.add(stringBuilder.toString());
        return ret;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
        System.out.println(eight.fullJustify(new String[]{"Here", "is", "an", "example", "of", "text", "justification."},14));

        System.out.println(eight.fullJustify(new String[]{""},2));

    }
}
