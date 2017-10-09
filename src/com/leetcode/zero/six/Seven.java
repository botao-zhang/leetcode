package com.leetcode.zero.six;

public class Seven {
    public String addBinary(String a, String b) {
        int ia = a.length() - 1,ib = b.length() - 1, plus = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (ia >= 0 || ib >= 0 || plus > 0){
            int sum = (ia >= 0 ? a.charAt(ia) - '0' : 0) +
                    (ib >= 0 ? b.charAt(ib) - '0' : 0) + plus;
            stringBuilder.insert(0,sum % 2);
            plus = sum / 2;
            ia--;
            ib--;
        }
        return stringBuilder.toString();
    }
}
