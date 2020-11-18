package com.example.ming.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
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
        for(int i=0; i<numList.size();) {
            int count = numList.get(i);
            List<Integer> tempList = new ArrayList<>();
            for(int j=i+1; j<i + count + 1; j++){
                if(!tempList.contains(numList.get(j))){
                    tempList.add(numList.get(j));
                }
            }
            tempList.sort(Integer::compareTo);
            for (Integer integer : tempList) {
                System.out.println(integer);
            }
            i = i + count + 1;
        }
    }
}
