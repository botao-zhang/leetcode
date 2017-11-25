package com.leetcode.two.seven;

public class Three {
    private String[] ones = new String[]{"One","Two","Three","Four","Five","One","Two","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] tens = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    private String convertSeg(int num){
        StringBuilder stringBuilder = new StringBuilder();
        int hun = num / 100;
        if(hun != 0){
            stringBuilder.append(ones[hun - 1]);
            stringBuilder.append(" Hundred");
            num = num % 100;
        }

        if(num != 0) {
            if (stringBuilder.length() > 0) stringBuilder.append(' ');
            if (num < 20) {
                stringBuilder.append(ones[num - 1]);
            }else{
                int tenth = num / 10;
                stringBuilder.append(tens[tenth - 2]);

                num = num % 10;
                if(num != 0){
                    if (stringBuilder.length() > 0) stringBuilder.append(' ');
                    stringBuilder.append(ones[num - 1]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        String[] higher = new String[]{"Thousand","Million","Billion"};
        while (num != 0){
            int seg = num % 1000;
            String segStr = convertSeg(seg);
            if(!segStr.isEmpty()) {
                if (stringBuilder.length() > 0) stringBuilder.insert(0, ' ');
                if (k > 0) segStr = segStr + " " + higher[k - 1];
            }
            stringBuilder.insert(0,segStr);
            num /= 1000;
            k++;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.numberToWords(123));
        System.out.println(three.numberToWords(12345));
        System.out.println(three.numberToWords(1234567));
    }
}
