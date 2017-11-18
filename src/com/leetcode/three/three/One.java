package com.leetcode.three.three;

public class One {


    public boolean isValidSerialization(String preorder) {
        int blank = 0,v = 0;
        String[] sep = preorder.split(",");
        for(int i = sep.length - 1;i>=0;i--){

            if(sep[i].equals("#")){
                blank++;
            }else{
                v++;
                if(blank - v < 1) break;
            }
            System.out.println("i = " + i + " b = " + blank + " v = " + v);
        }

        return blank - v == 1;
    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
