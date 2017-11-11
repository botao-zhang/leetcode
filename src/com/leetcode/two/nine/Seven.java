package com.leetcode.two.nine;

import com.leetcode.util.TreeNode;
import com.sun.tools.javac.jvm.Code;

import java.util.TreeMap;

public class Seven {
    public static class Codec {
        private void ser(TreeNode root,StringBuilder builder){
            builder.append('(');
            if(root == null) builder.append('N');
            else{
                builder.append(root.val);
                ser(root.left,builder);
                ser(root.right,builder);
            }
            builder.append(')');
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            ser(root,stringBuilder);
            return stringBuilder.toString();
        }
        private class Ret{
            TreeNode node;
            int off;
        }

        private Ret deser(String data, int off){
            System.out.println("data = " + data + " off = " + off);
            int i = off + 1;
            Ret ret = new Ret();

            while (data.charAt(i) != ')'){
                if(data.charAt(i) == '('){
                    ret.node = new TreeNode(Integer.parseInt(data.substring(off + 1,i)));
                    System.out.println("desered a node = " + ret.node);
                    Ret leftRet = deser(data,i);
                    ret.node.left = leftRet.node;
                    Ret rightRet = deser(data,leftRet.off + 1);
                    ret.node.right = rightRet.node;
                    i = rightRet.off;
                }
                i++;
            }

            ret.off = i;
            return ret;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deser(data,0).node;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = null;//new TreeNode(1);
        //node.left = new TreeNode(2);
        String str = codec.serialize(node);
        System.out.println(str);
        System.out.println(codec.deserialize(str));
    }
}
