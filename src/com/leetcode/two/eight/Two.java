package com.leetcode.two.eight;

import java.util.ArrayList;
import java.util.List;

public class Two {
    private void help(String num,int off, long cur, long multi, int target, StringBuilder stringBuilder, List<String> ret){
        //System.out.println("cur = " + cur + " mu = " + multi + " str = " + stringBuilder);
        if(off == num.length()){
            //System.out.println("cur = " + cur + " target = " + target);
            if(cur == target){
                //System.out.println("matching " + "cur = " + cur + " target = " + target);
                ret.add(stringBuilder.toString());
            }
            return;
        }

        int len = stringBuilder.length();
        for(int i = off;i<num.length();i++) {
            long n = Long.parseLong(num.substring(off, i + 1));

            if(stringBuilder.length() == 0){
                stringBuilder.append(n);
                help(num, i + 1, n, n, target, stringBuilder, ret);
                stringBuilder.delete(len,stringBuilder.length());
            }else {
                stringBuilder.append('+');
                stringBuilder.append(n);
                help(num, i + 1, cur + n, n, target, stringBuilder, ret);
                stringBuilder.delete(len, stringBuilder.length());

                stringBuilder.append('-');
                stringBuilder.append(n);
                help(num, i + 1, cur - n, -1 * n, target, stringBuilder, ret);
                stringBuilder.delete(len, stringBuilder.length());

                stringBuilder.append('*');
                stringBuilder.append(n);

                long newMulti = multi * n;
                help(num, i + 1, cur - multi + newMulti, newMulti, target, stringBuilder, ret);
                stringBuilder.delete(len, stringBuilder.length());
            }
            if (n == 0) break;
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        help(num,0,0,0,target,new StringBuilder(),ret);
        return ret;
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.addOperators("123",6));
        System.out.println(two.addOperators("232",8));
        System.out.println(two.addOperators("105",5));
        System.out.println(two.addOperators("00",0));
        System.out.println(two.addOperators("6237490",9191 - 34 + 5));
    }
}
