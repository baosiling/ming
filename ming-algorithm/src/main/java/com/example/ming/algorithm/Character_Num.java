package com.example.ming.algorithm;

import java.util.Scanner;

public class Character_Num {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str2 = scanner.next();
        str = str.toLowerCase();
        str2 = str2.toLowerCase();
        char c = str2.charAt(0);
        int count = 0;
        for(char cc : str.toCharArray()){
            if(cc == c){
                count++;
            }
        }
        System.out.println(count);
    }
}
