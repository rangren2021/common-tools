package com.study.common.server.exec;

/**
 * @ClassName _Test2
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/8 19:53
 * @Version 1.0
 **/

public class _Test2 {

    public static void getAns(int n) {
        int min = 1;
        int sum = 1;
        int max = 1;
        while(min <= n/2+1) {
            if(sum == n) {
                for(int k = min; k<=max; k++) {
                    System.out.println(k+"");
                }
                System.out.println();
                sum = sum - min;
                min ++;
                max ++;
                sum = sum+max;
            }
            if(sum > n) {
                sum = sum - min;
                min ++;
            } else {
                max ++;
                sum = sum + max;
            }
        }
    }
    public static void main(String[] args) {
        getAns(15);
    }
}
