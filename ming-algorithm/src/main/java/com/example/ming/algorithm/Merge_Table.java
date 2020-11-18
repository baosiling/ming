package com.example.ming.algorithm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-11-18 21:09
 */
public class Merge_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<count; i++) {
            Integer i1 = scanner.nextInt();
            Integer i2 = scanner.nextInt();
            if(map.containsKey(i1)){
                map.put(i1, map.get(i1)+i2);
            }else{
                map.put(i1, i2);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}