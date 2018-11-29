package com.study.common.server.utils.sort;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/29 15:29
 * @Version 1.0
 **/

public class InsertSort {

    private static int[] data = new int[]{123, 34, 13, 456, 456, 7457, 56, 7, 2, 23, 3, 45, 2};

    /**
     * 插入排序
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param numbers
     */
    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for (int i = 1; i < size; i++) {
            temp = numbers[i];
            for (j = i; j > 0 && temp < numbers[j - 1]; j--)
                numbers[j] = numbers[j - 1];
            numbers[j] = temp;
        }
    }

    public static void sort_m(int[] datas) {
        int length = datas.length;
        for (int i = 1; i < length; i++) {
            int sign = datas[i];
            int j;
            for (j = i; j > 0 && datas[j - 1] >= sign; j--) {
                datas[j] = datas[j - 1];
            }
            data[j] = sign;
        }
    }

    public static void main(String[] args) {
        sort_m(data);
        for (int item : data) {
            System.out.print(item + "  ");
        }
        System.out.println();
        System.out.println("-------------------");
    }
}
