package com.leetcode.three.zero;

public class Six {
    private boolean canBeAdditive(long f,long s,String num,int off){
        System.out.println("f = " + f + " s = " + s + " num = " + num + " off = " + off);
        if(off == num.length()) return true;

        if(num.charAt(off) == '0' && (f != 0 || s != 0)) return false;

        String sumstr = new Long(f + s).toString();
        if(num.startsWith(sumstr,off)){
            return canBeAdditive(s,f + s,num,off + sumstr.length());
        }
        return false;
    }

    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3) return false;
        for(int i = 0;i<num.length() / 2;i++){
            Long s1 = Long.parseLong(num.substring(0,i+1));
            for(int j = i + 1;j <= num.length() - Math.max(i + 1,j - i);j++){
                Long s2 = Long.parseLong(num.substring(i + 1,j+1));
                if(canBeAdditive(s1,s2,num,j + 1)) return true;
                if(num.charAt(i + 1) == '0') break;
            }


            if(num.charAt(0) == '0') break;
        }
        return false;
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.isAdditiveNumber("112358"));
        System.out.println(six.isAdditiveNumber("199100199"));
        System.out.println(six.isAdditiveNumber("011"));
        System.out.println(six.isAdditiveNumber("211738"));
        System.out.println(six.isAdditiveNumber("111"));
    }
}
