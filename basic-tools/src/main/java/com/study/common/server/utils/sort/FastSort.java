package com.study.common.server.utils.sort;

/**
 * 快速排序简单实现
 *
 * @ClassName FastSort
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/13 10:14
 * @Version 1.0
 **/

public class FastSort {

    private static int[] data = new int[]{123, 34, 13, 456, 456, 7457, 56, 7, 2, 23, 3, 45, 2};

    public static void sort(int[] data, int start, int end) {
        int st = start;
        int en = end;
        int value = data[start];
        while (st < en) {
            while (st < en && data[st] <= data[en])
                en--;
            if (value > data[en]) {
                int temp = data[en];
                data[en] = value;
                data[st] = temp;
            }

            while (st < en && data[en] >= data[st])
                st++;
            if (value < data[st]) {
                int temp = data[st];
                data[st] = value;
                data[en] = temp;
            }
        }
        if (start < st) sort(data, start, st - 1);
        if (end > en) sort(data, en + 1, end);
    }

    public static void main(String[] args) {
        sort(data, 0, data.length-1);

        for (int item : data) {
            System.out.print(item + "  ");
        }
        System.out.println();
        System.out.println("-------------------");
    }
}
