package com.atguigu.bean;

/**
 * @author k
 * @create 2021-05-14 20:48
 */
public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
//        System.out.println(demo.aToA("aa_bb"));
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'_');
    }
    public String aToA(String string){
        char[] chars = string.toCharArray();
        String newStr = "";
        for (int i =0;i<chars.length;i++) {
            if(chars[i] == '_'){
                newStr += String.valueOf(chars[i+1]).toUpperCase();
                i++;
            }
            else {
                newStr +=String.valueOf(chars[i]);
            }
        }
        return  newStr;
    }

    public String aToA2(String string){
        char[] chars = string.toCharArray();
        return null;
    }
}
