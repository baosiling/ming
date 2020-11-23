package com.example.ming.algorithm;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-11-20 20:32
 */
public class Weight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] heightArr = new int[count];
        int[] weightArr = new int[count];
        for(int i=0; i<count; i++) {
            heightArr[i] = scanner.nextInt();
        }
        for(int i=0; i<count; i++) {
            weightArr[i] = scanner.nextInt();
        }
        fun(heightArr, weightArr);

    }

    private static void fun(int[] heightArr, int[] weightArr) {
        int length = heightArr.length;
        List<Student> stuList = new ArrayList<>();
        for(int i=0; i<length; i++) {
            stuList.add(new Student(i+1, heightArr[i], weightArr[i]));
        }

        //排序
        List<Student> oneLoop = stuList.stream().sorted((o1, o2) -> {
            if(o1.height != o2.height){
                return o1.height - o2.height;
            }else{
                return o1.weight - o2.weight;
            }
        }).collect(Collectors.toList());

        String result = oneLoop.stream().map(t-> String.valueOf(t.index)).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    @Data
    private static class Student {
        int index;
        int height;
        int weight;
        public Student(int index, int height, int weight) {
            this.index = index;
            this.height = height;
            this.weight = weight;
        }

    }
}