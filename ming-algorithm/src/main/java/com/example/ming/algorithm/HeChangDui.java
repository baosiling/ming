package com.example.ming.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-11-19 20:48
 */
public class HeChangDui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(function(a));
        }
        sc.close();
    }

    // 实现合唱队排队的功能
    public static int function(int[] a) {
        int n = a.length;

        if (n == 0)
            return 0;

        int[] dpForword = dpForword(a);
        int[] dpBackward = dpBackward(a);

        System.out.println(Arrays.toString(dpForword));
        System.out.println(Arrays.toString(dpBackward));

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(dpForword[i] + dpBackward[i], max);
        }

        return n - (max - 1);
    }

    // 正向递增最长子序列
    public static int[] dpForword(int[] a) {
        int n = a.length;
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        return dp;
    }

    // 逆向递增最长子序列
    public static int[] dpBackward(int[] a) {
        int n = a.length;
        int[] dp = new int[n];

        dp[n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        return dp;
    }

}