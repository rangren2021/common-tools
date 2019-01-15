package com.study.common.server.exec;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/8 19:45
 * @Version 1.0
 **/

public class Test2 {

    public static void cal(int n) {
        int min = 1;
        int max = 1;
        int sum = 1;
        while (min <= n / 2 + 1) {
            if (sum == n) {
                for (int i = min; i <= max; i++) {
                    System.out.println(i + " ");
                }
                System.out.println("");
                max = min;
                sum = min;
            }
            if (sum < n) {
                max++;
                sum = sum + max;
            }
            if (sum > n) {
                sum = sum - min;
                min++;
            }
        }
    }

    public static void main(String[] args) {
        cal(15);
    }
}
