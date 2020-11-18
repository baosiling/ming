package com.example.ming.algorithm;

import java.util.Scanner;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-11-18 20:28
 */
public class String_Split {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            StringBuffer sb = new StringBuffer(str);
            int mod = str.length() % 8;
            if (mod != 0) {
                for (int i = 0; i < 8 - mod; i++) {
                    sb.append("0");
                }
            }
            str = sb.toString();
            for (int i = 0; i < str.length() / 8; i++) {
                System.out.println(str.substring(i * 8, (i + 1) * 8));
            }
        }
    }
}