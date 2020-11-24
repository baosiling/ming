package com.example.ming.algorithm;

import java.util.Arrays;

public class Brother_String {

    public static void main(String[] args) {
        System.out.println(checkBro("abc", "bca"));
    }

    /*
    校验单词和字符串是否为兄弟单词
     */
    public static boolean checkBro(String str, String word){
        if(str.isEmpty() || word.isEmpty()){
            return false;
        }
        if(str.equals(word) || str.length() != word.length()){
            return false;
        }
        char[] strc = str.toCharArray();
        char[] wordc = word.toCharArray();
        Arrays.sort(strc);
        Arrays.sort(wordc);
//        String strc1 = strc.toString();
        String strc1 = new String(strc);
//        String wordc1 = wordc.toString();
        String wordc1 = new String(wordc);
        if(strc1.equals(wordc1)){
            return true;
        };
        return false;
    }
}
