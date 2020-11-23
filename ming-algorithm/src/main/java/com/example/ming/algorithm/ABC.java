package com.example.ming.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-11-20 19:57
 */
public class ABC {
    public static void main(String[] args) {
//        A = B + 2C

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for(int i=0; i<arr.length; i++){
            arr[i] = scanner.nextInt();
        }

        boolean found = false;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                for(int k=0; k<arr.length; k++) {
                    if(arr[i] == arr[j] + 2*arr[k]){
                        if(i==j || i==k || j==k){
                            continue;
                        }else{
                            found = true;
                            System.out.print(arr[i] + " " + arr[j] + " " + arr[k] + " ");
                        }
                    }
                }
            }
        }
        if(!found){
            System.out.println(0);
        }
    }
}