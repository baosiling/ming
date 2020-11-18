package com.example.ming.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mingming_Num {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        while(true){
            String value = scanner.nextLine();
            if(value.equals("")){
                break;
            }
            numList.add(Integer.parseInt(value));
        }
        for(Integer i : numList) {

        }
        System.out.println(numList);
    }
}
